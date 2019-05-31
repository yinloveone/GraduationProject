package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.response.CustomCourseHour;

import java.util.List;

public interface CustomCourseHourMapper {
    List<CustomCourseHour> getHourById(Integer stuId);
    List<CustomCourseHour> getHourList(CustomCourseHour customCourseHour);
}
