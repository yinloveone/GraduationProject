package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Student;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface MemberService {
    PageInfo<CustomStudent> getStudentList(int pageCurrent, int pageSize, CustomStudent student);

    Result addStudent(Student student);

    Result addMemberTime(Student student);

    CustomStudent getStudent(Integer stuId);

    int deleteStudent(Integer stuId);

    Result updateStudent(Student student);

    Result modifyStudent(Student student);

    List<Student> getStudentList();

    Result uploadPortrait(Integer stuId,MultipartFile file);


}
