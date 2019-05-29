package com.pers.aiyin.fitness.entity;

import java.io.Serializable;
import java.util.Date;

public class CourseRecord implements Serializable {
    private Integer courseRecordId;

    private Integer stuId;

    private Integer courseId;

    private Date scdate;

    private Byte signIn;

    private String content;

    private Integer score;

    private Byte isValid;

    private Byte isDelete;

    private Date commentTime;

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

    public Byte getSignIn() {
        return signIn;
    }

    public void setSignIn(Byte signIn) {
        this.signIn = signIn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}