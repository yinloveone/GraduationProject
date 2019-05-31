package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.ClubCard;
import com.pers.aiyin.fitness.entity.CourseHour;
import com.pers.aiyin.fitness.response.CustomCourseHour;
import com.pers.aiyin.fitness.utils.Result;

import java.util.List;

public interface CourseHourService {
    List<CustomCourseHour> getByStuId(Integer stuId);
    Result addCourseHour(CourseHour courseHour);
    PageInfo<CustomCourseHour> getHourList(int pageCurrent, int pageSize, CustomCourseHour customCourseHour);
}
