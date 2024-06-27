package com.jaid.scheduler.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jaid.scheduler.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(nativeQuery = true, value = "select * from task where next_execution_time < :nextExecutionTime and status = :status")
    List<Task> findByNextExecutionTimeAndStatus(Long nextExecutionTime, String status);

}
