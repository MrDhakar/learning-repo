package com.jaid.scheduler.service;


import org.springframework.stereotype.Service;

import com.jaid.scheduler.data.TaskSchedule;

//@Component
//@Service
//public class JobSchedulerService {
//
//
//    @Autowired
//    JobRepository jobRepository;
//
//
//    @PostConstruct
//    private void test() {
//        Job j = new Job();
//        j.setRetryCount(1);
//        j.setCronExpression("dst");
//        jobRepository.save(j);
//    }
//
//}

@Service
public class JobSchedulerService implements IJobSchedularService {

    @Override
    public void save(TaskSchedule taskSchedule) {

    }

}
