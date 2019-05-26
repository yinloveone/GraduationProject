package com.pers.aiyin.fitness.entity;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {
    private Integer courseId;

    private String courseName;

    private Date courseTimeStart;

    private Date courseTimeEnd;

    private Integer roomId;

    private Integer coachId;

    private String courseType;

    private Integer courseCapacity;

    private Integer courseSurplus;

    private Byte isValid;

    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Date getCourseTimeStart() {
        return courseTimeStart;
    }

    public void setCourseTimeStart(Date courseTimeStart) {
        this.courseTimeStart = courseTimeStart;
    }

    public Date getCourseTimeEnd() {
        return courseTimeEnd;
    }

    public void setCourseTimeEnd(Date courseTimeEnd) {
        this.courseTimeEnd = courseTimeEnd;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public Integer getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(Integer courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public Integer getCourseSurplus() {
        return courseSurplus;
    }

    public void setCourseSurplus(Integer courseSurplus) {
        this.courseSurplus = courseSurplus;
    }

    public Byte getIsValid() {
        return isValid;
    }

    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}