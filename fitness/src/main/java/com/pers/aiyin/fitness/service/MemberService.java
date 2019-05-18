package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Student;
import com.pers.aiyin.fitness.response.CustomStudent;


public interface MemberService {
    PageInfo<CustomStudent> getStudentList(int pageCurrent, int pageSize, CustomStudent student);

    int addStudent(Student student);

    CustomStudent getStudent(Integer stuId);

    int deleteStudent(Integer stuId);

    int updateStudent(Student student);
}
