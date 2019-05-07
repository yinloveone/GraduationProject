package com.pers.aiyin.fitness.controller;

import com.pers.aiyin.fitness.entity.CourseHour;
import com.pers.aiyin.fitness.service.CourseHourService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CourseHourController {

    @Autowired
    private CourseHourService courseHourService;

    @PostMapping("courseHour/addCourseHour")
    public Result addCourseHour(CourseHour courseHour){
        int count = courseHourService.addCourseHour(courseHour);
        if(count>0){
            return Result.success();
        }
        return Result.failure(ResponseCode.FAIL);

    }
}
