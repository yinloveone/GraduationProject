package com.pers.aiyin.fitness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.entity.CourseHour;
import com.pers.aiyin.fitness.entity.CourseRecord;
import com.pers.aiyin.fitness.entity.User;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.response.PrivateCourse;
import com.pers.aiyin.fitness.service.CourseHourService;
import com.pers.aiyin.fitness.service.CourseRecordService;
import com.pers.aiyin.fitness.service.PrivateCourseService;
import com.pers.aiyin.fitness.service.UserService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
/*
*
*学员
* */

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CourseHourService courseHourService;

    @Autowired
    private CourseRecordService courseRecordService;

    @Autowired
    private PrivateCourseService privateCourseService;

    @PostMapping("/user/stuLogin")
    public Result loginCon(HttpServletRequest request) throws
            IOException {
        //获取请求Json数据流中登陆信息
         CustomStudent student=new ObjectMapper().readValue(request.getInputStream(), CustomStudent.class);
         //验证用户身份信息
         CustomStudent u  =userService.stuLogin(student);
         //返回结果
        if(null!=u){
          return  Result.success(u);
        }else{
           return Result.failure(ResponseCode.FAIL);
        }
    }
    /*
    * 获取可预约课程(团体课程)
    * */
    @GetMapping("/user/getCourse/{dateSelect}")
    public Result getCourse(@PathVariable("dateSelect") Date dateSelect){
        List<Course> list = userService.getCourse(dateSelect);
        if(null!=list&&list.size()!=0){
            return Result.success(list);
        }else{
            return Result.failure(ResponseCode.FAIL);
        }
    }
    /*
     * 获取可预约课程(私教课程)
     * */
    @PostMapping("/user/getPrivateCourse")
    public Result getPrivateCourse(HttpServletRequest request) throws
            IOException {
        PrivateCourse privateCourse = new ObjectMapper().readValue(
                request.getInputStream(), PrivateCourse.class);
    return privateCourseService.getPrivateCourse(privateCourse);
    }


    /*
    * 预约课程
    * */
    @PostMapping("/user/orderCourse")
    public Result orderCourse(HttpServletRequest request) throws
            IOException {
        CourseRecord courseRecord=new ObjectMapper().readValue(
                request.getInputStream(), CourseRecord.class);

       return courseRecordService.orderCourse(courseRecord);
    }
    /*
    * 取消预约课程
    * */
    @PostMapping("/user/cancelOrder")
    public Result cancelOrder(HttpServletRequest request) throws
            IOException {
        CourseRecord courseRecord=new ObjectMapper().readValue(
                request.getInputStream(), CourseRecord.class);
        return courseRecordService.cancelOrder(courseRecord);
    }

    /*
    * 课时查询
    * */
    @GetMapping("/user/getCourseHour/{stuId}")
    public Result getCourseHour(@PathVariable("stuId") Integer stuId)  {
       List<CourseHour> list = courseHourService.getByStuId(stuId);
       if(null!=list&&list.size()!=0){
           return Result.success(list);
       }else{
           return Result.failure(ResponseCode.FAIL);
       }
    }



}
