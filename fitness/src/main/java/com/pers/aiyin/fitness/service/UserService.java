package com.pers.aiyin.fitness.service;

import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
     String login(User user);
     int register(User user);
     List<Course> getCourse();
}
