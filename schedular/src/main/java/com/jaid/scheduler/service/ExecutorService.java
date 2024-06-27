package com.jaid.scheduler.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jaid.scheduler.controller.JobSchedularController;
import com.jaid.scheduler.data.Status;
import com.jaid.scheduler.entity.Job;
import com.jaid.scheduler.entity.Task;
import com.jaid.scheduler.entity.TaskHistory;
import com.jaid.scheduler.repository.JobRepository;
import com.jaid.scheduler.repository.TaskHistoryRepository;
import com.jaid.scheduler.repository.TaskRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExecutorService {

    private static final Logger log = LoggerFactory.getLogger(ExecutorService.class);
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskHistoryRepository taskHistoryRepository;

    @Autowired
    JobSchedularController jobSchedularController;



    @Autowired
    JobRepository jobRepository;

    @Async
    public void execute(Task task) {

        Job job = jobRepository.findById(task.getJobId()).get();
        try {
            log.info("Started Executing job with id :{}", task.getJobId());
            Process process = Runtime.getRuntime().exec(job.getJobName());
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);

            if(exitCode != 0) throw new Exception("Job Failed");
            TaskHistory taskHistory = new TaskHistory();
            taskHistory.setJobId(task.getJobId());
            taskHistory.setNextExecutionTime(task.getNextExecutionTime());
            taskHistory.setStatus(Status.COMPLETED);
            taskHistoryRepository.save(taskHistory);
        } catch (Exception e) {
            TaskHistory taskHistory = new TaskHistory();
            taskHistory.setJobId(task.getJobId());
            taskHistory.setNextExecutionTime(task.getNextExecutionTime());
            taskHistory.setStatus(Status.FAILED);
            taskHistoryRepository.save(taskHistory);
        } finally {
            task.setStatus(Status.PENDING);
            task.setNextExecutionTime(jobSchedularController.getNextExecutionTime(job.getCronExpression()));
            taskRepository.save(task);
        }
    }
}
