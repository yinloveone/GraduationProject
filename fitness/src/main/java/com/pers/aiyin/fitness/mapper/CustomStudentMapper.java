package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.response.CustomStudent;

import java.util.List;

public interface CustomStudentMapper {

    List<CustomStudent> getStudentList(CustomStudent student);

    CustomStudent getStudent(Integer stuId);

    CustomStudent stuLogin(CustomStudent customStudent);
}
