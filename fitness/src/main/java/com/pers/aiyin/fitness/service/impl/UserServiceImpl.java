package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.entity.Student;
import com.pers.aiyin.fitness.mapper.CustomStudentMapper;
import com.pers.aiyin.fitness.mapper.UserMapper;
import com.pers.aiyin.fitness.response.CustomCourse;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.response.PrivateCourse;
import com.pers.aiyin.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
    public List<CustomCourse> getCourse(PrivateCourse privateCourse){
        return userDao.getCourse(privateCourse);
    }
}
