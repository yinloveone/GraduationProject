package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.response.CustomCourse;
import com.pers.aiyin.fitness.response.PrivateCourse;

import java.util.List;
import java.util.Map;

public interface PrivateCourseMapper {
  List<PrivateCourse> getPrivateCourse(Map<String,Object> map);
  List<Integer> getCoachId(Integer stuId);
  List<CustomCourse> getPrivateList(Map<String,Object> map) ;
}
