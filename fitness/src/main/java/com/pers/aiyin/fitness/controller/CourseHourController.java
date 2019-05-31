package com.pers.aiyin.fitness.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pers.aiyin.fitness.entity.ClubCard;
import com.pers.aiyin.fitness.entity.CourseHour;
import com.pers.aiyin.fitness.response.CustomCourseHour;
import com.pers.aiyin.fitness.service.CourseHourService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
public class CourseHourController {

    @Autowired
    private CourseHourService courseHourService;

    @PostMapping("courseHour/addCourseHour")
    public Result addCourseHour(CourseHour courseHour){
       return courseHourService.addCourseHour(courseHour);
    }
    @PostMapping("courseHour/courseHourList")
    public String getHourList(Integer rows, Integer page, CustomCourseHour customCourseHour){
        Map<String,Object> resultMap=new HashMap<>();
        PageInfo<CustomCourseHour> pageInfo = courseHourService.getHourList(page,rows,customCourseHour);
        resultMap.put("rows",pageInfo.getList());
        resultMap.put("total",pageInfo.getTotal());
        return new Gson().toJson(resultMap);
    }
}
