package com.pers.aiyin.fitness.controller;

import com.pers.aiyin.fitness.response.CustomCourseRecord;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* 学生和教练的课表管理
* */

@RestController
@RequestMapping("api")
public class CourseRecordController {

    /*
    * *根据学生id获得课程表
     */
    @PostMapping("/courseRecord/getRecordById/{stuId}")
    public List<CustomCourseRecord> getRecordById(@PathVariable("stuId") Integer stuId){
        return null;
    }

    /*
     * *根据教练id获得课程表
     */
    @PostMapping("/courseRecord/getRecordByCoachId/{coachId}")
    public List<CustomCourseRecord> getRecordByCoachId(@PathVariable("coachId") Integer coachId){
        return null;
    }

}
