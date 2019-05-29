package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.mapper.CustomStudentMapper;
import com.pers.aiyin.fitness.mapper.UserMapper;
import com.pers.aiyin.fitness.response.CustomCourse;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.response.PrivateCourse;
import com.pers.aiyin.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        if(privateCourse.getCourseTimeStart()==null){
            Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
            c.add(Calendar.DAY_OF_MONTH, 1);
            privateCourse.setCourseTimeStart(c.getTime());
        }
        return userDao.getCourse(privateCourse);
    }
}
