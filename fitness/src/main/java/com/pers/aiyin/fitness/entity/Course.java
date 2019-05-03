package com.pers.aiyin.fitness.entity;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {
    private Integer courseId;

    private String courseName;

    private Date courseTimeStart;

    private Date courseTimeEnd;

    private Integer roomId;

    private String roomName;

    private Integer coachId;

    private String coachName;

    private String courseType;

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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName == null ? null : coachName.trim();
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }
}