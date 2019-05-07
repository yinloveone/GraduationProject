package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.entity.Student;
import com.pers.aiyin.fitness.mapper.CustomStudentMapper;
import com.pers.aiyin.fitness.mapper.UserMapper;
import com.pers.aiyin.fitness.entity.User;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

/*
*
*学员用户service
* */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Autowired
    private CustomStudentMapper customStudentMapper;

    public CustomStudent stuLogin(CustomStudent student){

        return customStudentMapper.stuLogin(student);
    }
    public List<Course> getCourse(Date selectDate){
        Map<String,Object> map=new HashMap<>();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(selectDate.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        Date beginDate = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
        map.put("beginDate",beginDate);
        map.put("endDate",endDate);
        map.put("courseType",1);
        return userDao.getCourse(map);
    }
}
