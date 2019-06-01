package com.pers.aiyin.fitness.response;

import lombok.Data;

import java.util.Date;


@Data
public class CourseRecordOption {
    private Integer stuId;
    private Integer coachId;
    private Date dateRange;
    private Date dateRangeEnd;
}
