package com.pers.aiyin.fitness.response;

import lombok.Data;

import java.util.Date;

@Data
public class CustomCourseR {
    private Integer courseRecordId;
    private Integer stuId;
    private Integer courseId;
    private String stuName;
    private String courseName;
    private Byte signIn;
    private String content;
    private Integer score;
    private Date courseTimeStart;
    private Date courseTimeEnd;
    private String timeStartStr;
    private String timeEndStr;
    private Double avgScore;

}
