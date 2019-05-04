package com.pers.aiyin.fitness.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pers.aiyin.fitness.entity.Student;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.service.MemberService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
* 会员管理
* */
@RestController("api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member/studentList")
    public String getList(Integer rows, Integer page){
        Map<String,Object> resultMap=new HashMap<>();
        PageInfo<CustomStudent> pageInfo=memberService.getStudentList(rows,page);
        resultMap.put("rows",pageInfo.getList());
        resultMap.put("total",pageInfo.getList().size());
        return new Gson().toJson(resultMap);
    }

    @PostMapping("/member/addStudent")
    public Result addStudent(Student student){
        int result=memberService.addStudent(student);
        if(result!=-1){
          return Result.success();
        }else
        {
            return  Result.failure(ResponseCode.FAIL);
        }
    }

    @PostMapping("/member/getStudent/{stuId}")
    public Result getStudent(@PathVariable("stuId") Integer stuId){
        CustomStudent customStudent=memberService.getStudent(stuId);
        if(null!=customStudent){
            return Result.success(customStudent);
        }
        return Result.failure(ResponseCode.FAIL);
    }

    @PostMapping("/member/deleteStudent/{stuId}")
    public Result deleteStudent(@PathVariable("stuId") Integer stuId){
        int result=memberService.deleteStudent(stuId);
        if(result!=-1){
            return Result.success();
        }else
        {
            return  Result.failure(ResponseCode.FAIL);
        }
    }
    @PostMapping("/member/updateStudent")
    public Result updateStudent(Student student){
        int result=memberService.updateStudent(student);
        if(result!=-1){
            return Result.success();
        }else
        {
            return  Result.failure(ResponseCode.FAIL);
        }
    }

}
