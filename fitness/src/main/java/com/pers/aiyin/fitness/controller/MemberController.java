package com.pers.aiyin.fitness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pers.aiyin.fitness.entity.Student;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.service.MemberService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 会员管理
* */
@RestController
@RequestMapping("api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member/studentList")
    public String getList(Integer rows, Integer page,CustomStudent student){
        Map<String,Object> resultMap=new HashMap<>();
        PageInfo<CustomStudent> pageInfo=memberService.getStudentList(rows,page,student);
        resultMap.put("rows",pageInfo.getList());
        resultMap.put("total",pageInfo.getTotal());
        return new Gson().toJson(resultMap);
    }

    @PostMapping("/member/addStudent")
    public Result addStudent(Student student){
        return memberService.addStudent(student);
    }

    @GetMapping("/member/getStudentList")
    public Result getStudentList(){
        List<Student> list=memberService.getStudentList();
        if(null!=list){
            return Result.success(list);
        }
        return Result.failure(ResponseCode.FAIL);
    }
    @GetMapping("/member/getStudent/{stuId}")
    public Result getStudent(@PathVariable("stuId") Integer stuId){
        CustomStudent customStudent=memberService.getStudent(stuId);
        if(null!=customStudent){
            return Result.success(customStudent);
        }
        return Result.failure(ResponseCode.FAIL);
    }


    /*
    * 学员修改自己的基本信息
    * */
    @PostMapping("/member/modifyStudent")
    public Result modifyStudent(HttpServletRequest request) throws
            IOException {
        Student student=new ObjectMapper().readValue(
                request.getInputStream(),Student.class);
        return memberService.modifyStudent(student);
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
    /*
    * 会员卡转让
    * */
    @PostMapping("/member/updateStudent")
    public Result updateStudent(Student student){
        return memberService.updateStudent(student);
    }

    /*
    * 学员上传自己的头像
    * */
    @PostMapping("member/uploadPortrait")
    public Result uploadPortrait(Integer stuId, MultipartFile file ){
      /*  Portrait portrait =new ObjectMapper().readValue(
                request.getInputStream(), Portrait.class);*/
        if(null!=stuId&&null!=file){
            return memberService.uploadPortrait(stuId,file);

        }

        return Result.failure(ResponseCode.FAIL);
    }

}
