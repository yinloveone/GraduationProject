package com.pers.aiyin.fitness.entity;

import java.io.Serializable;
import java.util.Date;

public class WeightRecord implements Serializable {
    private Integer weiRecordId;

    private Double weight;

    private Date recordTime;

    private Byte isValid;

    private Integer stuId;

    private static final long serialVersionUID = 1L;

    public Integer getWeiRecordId() {
        return weiRecordId;
    }

    public void setWeiRecordId(Integer weiRecordId) {
        this.weiRecordId = weiRecordId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Byte getIsValid() {
        return isValid;
    }

    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }
}