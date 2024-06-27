package com.jaid.scheduler.entity;


import com.jaid.scheduler.data.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

    @Id
    private Integer jobId;

    private Long nextExecutionTime;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Long getNextExecutionTime() {
        return nextExecutionTime;
    }

    public void setNextExecutionTime(Long nextExecutionTime) {
        this.nextExecutionTime = nextExecutionTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
