package com.pers.aiyin.fitness.controller;

import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.entity.CourseHour;
import com.pers.aiyin.fitness.entity.CourseRecord;
import com.pers.aiyin.fitness.entity.User;
import com.pers.aiyin.fitness.service.CourseHourService;
import com.pers.aiyin.fitness.service.CourseRecordService;
import com.pers.aiyin.fitness.service.UserService;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/*
*
*学员
* */

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CourseHourService courseHourService;

    @Autowired
    private CourseRecordService courseRecordService;

    @PostMapping("/loginPage")
    public Map<String, Object> loginCon(HttpServletRequest request) throws
            IOException {
       Map<String,Object> result=new HashMap<>();
        User user=new ObjectMapper().readValue(request.getInputStream(), User.class);
        String userName=userService.login(user);
        if(null!=userName&&!"".equals(userName)){
            result.put("status", 0);
            result.put("result", userName);
            result.put("msg", "登陆成功");
        }else{
            result.put("status", 1);
            result.put("msg", "请检查你的用户名和密码");
        }
       return result;
    }
    @PostMapping("/register")
    public Map<String, Object> register(HttpServletRequest request) throws IOException{
        Map<String, Object> result = new HashMap<>();
        User user=new ObjectMapper().readValue(request.getInputStream(), User.class);
        int id=userService.register(user);
        if(id!=0){
            result.put("status", 0);
            result.put("result", id);
            result.put("msg", "注册成功");
        }
        else{
            result.put("status", 1);
            result.put("msg", "注册失败");
        }
        return result;
    }

    /*
    * 获取可预约课程
    * */
    @PostMapping("/getCourse")
    public List<Course> getCourse(){
        return userService.getCourse();
    }

    /*
    * 预约课程
    * */
    @PostMapping("/orderCourse")
    public Result orderCourse(CourseRecord courseRecord){
        String str = courseRecordService.orderCourse(courseRecord);
       return new Result(200,str);
    }



    /*
    * 取消预约课程
    * */
    @PostMapping("/cancelOrder")
    public Result cancelOrder(CourseRecord courseRecord){
        return new Result();
    }

    /*
    * 课时查询
    * */
    @PostMapping("/getCourseHour/{stuId}")
    public List<CourseHour> getCourseHour(@PathVariable("stuId") Integer stuId){
        return courseHourService.getByStuId(stuId);
    }



}
