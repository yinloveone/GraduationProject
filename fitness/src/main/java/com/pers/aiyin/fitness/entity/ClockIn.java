package com.pers.aiyin.fitness.entity;

import java.io.Serializable;
import java.util.Date;

public class ClockIn implements Serializable {
    private Integer clockInId;

    private Date clockTime;

    private String cockContent;

    private Integer stuId;

    private Byte isValid;

    private static final long serialVersionUID = 1L;

    public Integer getClockInId() {
        return clockInId;
    }

    public void setClockInId(Integer clockInId) {
        this.clockInId = clockInId;
    }

    public Date getClockTime() {
        return clockTime;
    }

    public void setClockTime(Date clockTime) {
        this.clockTime = clockTime;
    }

    public String getCockContent() {
        return cockContent;
    }

    public void setCockContent(String cockContent) {
        this.cockContent = cockContent == null ? null : cockContent.trim();
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Byte getIsValid() {
        return isValid;
    }

    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }
}