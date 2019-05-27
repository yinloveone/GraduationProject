package com.pers.aiyin.fitness.service;

import com.pers.aiyin.fitness.response.CustomCourse;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.response.PrivateCourse;

import java.util.List;


public interface UserService {
    List<CustomCourse> getCourse(PrivateCourse privateCourse);
    CustomStudent stuLogin(CustomStudent student);
}
