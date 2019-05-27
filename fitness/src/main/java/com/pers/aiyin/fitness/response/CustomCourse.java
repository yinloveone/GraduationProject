package com.pers.aiyin.fitness.response;

import lombok.Data;

import java.util.Date;

@Data
public class CustomCourse {
    private Integer courseId;

    private String courseName;

    private String currDate;

    private Date courseTimeStart;

    private String timeStartStr;

    private Date courseTimeEnd;

    private String timeEndStr;

    private String formatDate;

    private Integer roomId;

    private String roomName;

    private Integer coachId;

    private String coachName;

    private String courseType;

    private Integer courseCapacity;

    private Integer courseSurplus;


}
