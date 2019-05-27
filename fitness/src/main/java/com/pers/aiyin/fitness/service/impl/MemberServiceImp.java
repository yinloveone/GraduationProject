package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Student;
import com.pers.aiyin.fitness.entity.StudentExample;
import com.pers.aiyin.fitness.mapper.StudentMapper;
import com.pers.aiyin.fitness.mapper.CustomStudentMapper;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.service.MemberService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
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
    public Result addStudent(Student student){
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria=example.createCriteria();
        criteria.andPhoneEqualTo(student.getPhone());
        List<Student> list = studentMapper.selectByExample(example);
        if(null!=list&&list.size()>0){

            return new Result(1,"此电话号码已经存在");
        }else{
            StudentExample.Criteria criteria1=example.createCriteria();
            criteria1.andEmailEqualTo(student.getEmail());
            example.or(criteria1);
            example.or(criteria);
            List<Student> list2 = studentMapper.selectByExample(example);
            if(null!=list2&&list2.size()>0){
                return new Result(1,"此邮箱已经存在");
            }else{
                student.setPassword("123");
                student.setRestDate(new Date());
                Date date=new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                if(student.getCardId()==1){
                    cal.add(Calendar.MONTH, 1);
                    student.setDueDate(cal.getTime());

                }else if(student.getCardId()==2){
                    cal.add(Calendar.MONTH, 3);
                    student.setDueDate(cal.getTime());
                }else{
                    cal.add(Calendar.YEAR, 1);
                    student.setDueDate(cal.getTime());
                }
                int result = studentMapper.insertSelective(student);
                if(result!=-1){
                    return Result.success();
                }else
                {
                    return  Result.failure(ResponseCode.FAIL);
                }
            }

        }


    }

    @Override
    public Result modifyStudent(Student student){
        int result = studentMapper.updateByPrimaryKeySelective(student);
        if (result != -1) {
            return Result.success();
        } else {
            return Result.failure(ResponseCode.FAIL);
        }
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
    public Result updateStudent(Student student) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(student.getPhone());
        List<Student> list = studentMapper.selectByExample(example);
        if (null != list && list.size() > 0) {

            return new Result(1, "此电话号码已经存在");
        } else {
            StudentExample.Criteria criteria1 = example.createCriteria();
            criteria1.andEmailEqualTo(student.getEmail());
            example.or(criteria1);
            example.or(criteria);
            List<Student> list2 = studentMapper.selectByExample(example);
            if (null != list2 && list2.size() > 0) {
                return new Result(1, "此邮箱已经存在");
            } else {
                student.setPassword("123");
                int result = studentMapper.updateByPrimaryKeySelective(student);
                if (result != -1) {
                    return Result.success();
                } else {
                    return Result.failure(ResponseCode.FAIL);
                }

            }
        }
    }

}
