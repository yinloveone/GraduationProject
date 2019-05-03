package com.pers.aiyin.fitness.entity;

import java.io.Serializable;
import java.util.Date;

public class DietRecord implements Serializable {
    private Integer dietId;

    private Date dietDate;

    private Integer stuId;

    private String dietContent;

    private static final long serialVersionUID = 1L;

    public Integer getDietId() {
        return dietId;
    }

    public void setDietId(Integer dietId) {
        this.dietId = dietId;
    }

    public Date getDietDate() {
        return dietDate;
    }

    public void setDietDate(Date dietDate) {
        this.dietDate = dietDate;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getDietContent() {
        return dietContent;
    }

    public void setDietContent(String dietContent) {
        this.dietContent = dietContent == null ? null : dietContent.trim();
    }
}