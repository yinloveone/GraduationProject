package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Student;
import com.pers.aiyin.fitness.mapper.StudentMapper;
import com.pers.aiyin.fitness.mapper.CustomStudentMapper;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    private CustomStudentMapper customStudentMapper;

    @Autowired

    private StudentMapper studentMapper;

    @Override
    public PageInfo<CustomStudent> getStudentList(int pageSize,int pageCurrent,CustomStudent student){
        PageHelper.startPage(pageCurrent, pageSize);
        List<CustomStudent> list =  customStudentMapper.getStudentList(student);
        PageInfo<CustomStudent> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addStudent(Student student){
        student.setPassword("123");
        return studentMapper.insertSelective(student);
    }

    @Override
    public CustomStudent getStudent(Integer stuId){
        return customStudentMapper.getStudent(stuId);
    }

    @Override
    public int deleteStudent(Integer stuId){
        return studentMapper.deleteByPrimaryKey(stuId);
    }

    @Override
    public int updateStudent(Student student){
        return studentMapper.updateByPrimaryKey(student);
    }


}
