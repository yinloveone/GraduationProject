package com.pers.aiyin.fitness.response;

import lombok.Data;

import java.util.List;

@Data
public class CourseRecordList {
    private String yearMonth;
    private List<CustomCourseRecord> listCourse;
}
