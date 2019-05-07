package com.pers.aiyin.fitness.response;

import lombok.Data;

import java.util.Date;

@Data
public class PrivateCourse {
    private Integer stuId;
    private Integer courseId;
    private String courseName;
    private Integer coachId;
    private String coachName;
    private String gradeStr;
    private Integer grade;
    private Date courseTimeStart;
    private Date courseTimeEnd;
}
