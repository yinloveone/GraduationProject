package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.entity.Student;
import com.pers.aiyin.fitness.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

   /* Student login(Student student);

    int insert(User user);*/

    List<Course> getCourse(Map<String,Object> map);

}
