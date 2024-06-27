package com.jaid.scheduler.entity;

import com.jaid.scheduler.data.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_history")
public class TaskHistory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer jobId;

    private Long executionTime;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Long getNextExecutionTime() {
        return executionTime;
    }

    public void setNextExecutionTime(Long nextExecutionTime) {
        this.executionTime = nextExecutionTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
