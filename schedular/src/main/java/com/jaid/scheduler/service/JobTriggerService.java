package com.jaid.scheduler.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jaid.scheduler.data.Status;
import com.jaid.scheduler.entity.Task;
import com.jaid.scheduler.repository.TaskRepository;

@Service
public class JobTriggerService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ExecutorService executorService;

    @Scheduled(cron="0 * * * * *")
    public void  triggerJobs() {
        Long currentTime = LocalDateTime.now().atZone(ZoneOffset.systemDefault()).toInstant().getEpochSecond();
        List<Task> tasks = taskRepository.findByNextExecutionTimeAndStatus(currentTime, Status.PENDING.toString());
        for(Task task : tasks) {
            executorService.execute(task);
        }
    }
}
