package com.pers.aiyin.fitness.response;

import lombok.Data;

@Data
public class CustomCourseHour {
    private Integer hourId;

    private String hourName;

    private Integer coachId;

    private Integer hourCount;

    private Integer stuId;

    private String coachName;

    private String stuName;
}
