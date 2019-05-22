package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.response.PrivateCourse;


import java.util.List;
import java.util.Map;

public interface UserMapper {

   /* Student login(Student student);

    int insert(User user);*/

    List<Course> getCourse(PrivateCourse privateCourse);

}
