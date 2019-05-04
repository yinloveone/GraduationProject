package com.pers.aiyin.fitness.service;

import com.pers.aiyin.fitness.entity.CourseHour;

import java.util.List;

public interface CourseHourService {
    List<CourseHour> getByStuId(Integer stuId);
}
