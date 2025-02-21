package com.epam.Models;

import org.springframework.stereotype.Component;

import java.util.Objects;

public class JobTitle {
    String jobDesignation;
    Long jobId,salaryLowerRange,salaryUpperRange;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        JobTitle jobTitle = (JobTitle) o;
        return Objects.equals(getJobDesignation(), jobTitle.getJobDesignation()) && Objects.equals(getJobId(), jobTitle.getJobId()) && Objects.equals(getSalaryLowerRange(), jobTitle.getSalaryLowerRange()) && Objects.equals(getSalaryUpperRange(), jobTitle.getSalaryUpperRange());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJobDesignation(), getJobId(), getSalaryLowerRange(), getSalaryUpperRange());
    }

    public JobTitle(String jobDesignation, Long jobId, Long salaryLowerRange, Long salaryUpperRange) {
        this.jobDesignation = jobDesignation;
        this.jobId = jobId;
        this.salaryLowerRange = salaryLowerRange;
        this.salaryUpperRange = salaryUpperRange;
    }

    public String getJobDesignation() {
        return jobDesignation;
    }

    public void setJobDesignation(String jobDesignation) {
        this.jobDesignation = jobDesignation;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getSalaryLowerRange() {
        return salaryLowerRange;
    }

    public void setSalaryLowerRange(Long salaryLowerRange) {
        this.salaryLowerRange = salaryLowerRange;
    }

    public Long getSalaryUpperRange() {
        return salaryUpperRange;
    }

    public void setSalaryUpperRange(Long salaryUpperRange) {
        this.salaryUpperRange = salaryUpperRange;
    }

    @Override
    public String toString() {
        return "JobTitle{" +
                "jobDesignation='" + jobDesignation + '\'' +
                ", jobId=" + jobId +
                ", salaryLowerRange=" + salaryLowerRange +
                ", salaryUpperRange=" + salaryUpperRange +
                '}';
    }
}
