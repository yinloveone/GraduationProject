package com.pers.aiyin.fitness.entity;

import java.io.Serializable;

public class CourseHour implements Serializable {
    private Integer hourId;

    private String hourName;

    private Integer coachId;

    private Integer hourCount;

    private Integer stuId;

    private static final long serialVersionUID = 1L;

    public Integer getHourId() {
        return hourId;
    }

    public void setHourId(Integer hourId) {
        this.hourId = hourId;
    }

    public String getHourName() {
        return hourName;
    }

    public void setHourName(String hourName) {
        this.hourName = hourName == null ? null : hourName.trim();
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getHourCount() {
        return hourCount;
    }

    public void setHourCount(Integer hourCount) {
        this.hourCount = hourCount;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }
}