package com.pers.aiyin.fitness.service;

import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.response.CustomStudent;

import java.util.Date;
import java.util.List;


public interface UserService {
     List<Course> getCourse(Date selectDate);
    CustomStudent stuLogin(CustomStudent student);
}
