package com.pers.aiyin.fitness.response;

import lombok.Data;

import java.util.Date;

@Data
public class CustomCourseRecord {
    private Integer courseRecordId;

    private Integer stuId;

    private Integer courseId;

    private String courseName;

    private Date courseTimeStart;

    private Date courseTimeEnd;

    private String timeStartStr;

    private String timeEndStr;

    private Integer roomId;

    private String roomName;

    private Integer coachId;

    private String coachName;

    private String monthDate;

    private Integer score;

}
