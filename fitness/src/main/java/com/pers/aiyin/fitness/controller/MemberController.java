package com.pers.aiyin.fitness.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member/studentList")
    public String getList(Integer pageSize, Integer pageNumber){
        Map<String,Object> resultMap=new HashMap<>();
        PageInfo<CustomStudent> pageInfo=memberService.getStudentList(pageNumber,pageSize);
        resultMap.put("rows",pageInfo.getList());
        resultMap.put("total",pageInfo.getList().size());
        return new Gson().toJson(resultMap);

    }



}
