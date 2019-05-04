package com.pers.aiyin.fitness.mapper.custom;

import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    String login(User user);

    int insert(User user);

    List<Course> getCourse(Map<String,Object> map);

}
