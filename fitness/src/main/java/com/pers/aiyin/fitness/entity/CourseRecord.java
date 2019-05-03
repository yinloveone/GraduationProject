package com.pers.aiyin.fitness.entity;

import java.io.Serializable;
import java.util.Date;

public class CourseRecord implements Serializable {
    private Integer courseRecordId;

    private Integer stuId;

    private Integer courseId;

    private Date scdate;

    private static final long serialVersionUID = 1L;

    public Integer getCourseRecordId() {
        return courseRecordId;
    }

    public void setCourseRecordId(Integer courseRecordId) {
        this.courseRecordId = courseRecordId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getScdate() {
        return scdate;
    }

    public void setScdate(Date scdate) {
        this.scdate = scdate;
    }
}