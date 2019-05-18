package com.pers.aiyin.fitness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.response.PrivateCourse;
import com.pers.aiyin.fitness.service.CoachService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
* 教练管理
*
* */

@RestController
@RequestMapping("api")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping("/coach/coachList")
    public String getCoachList(Integer rows, Integer page){
        Map<String,Object> resultMap=new HashMap<>();
        PageInfo<Coach> pageInfo = coachService.getCoachList(rows,page);
        resultMap.put("rows",pageInfo.getList());
        resultMap.put("total",pageInfo.getList().size());
        return new Gson().toJson(resultMap);
    }

    @PostMapping("/coach/addCoach")
    public Result addCoach(Coach coach){
        int result = coachService.addCoach(coach);
        if(result != -1){
            return Result.success();
        }else {
            return  Result.failure(ResponseCode.FAIL);
        }
    }
    @PostMapping("/coach/getCoach/{coachId}")
    public Result getCoach(@PathVariable("coachId") Integer coachId){
        Coach coach = coachService.getCoach(coachId);
        if(null!=coach){
            return Result.success(coach);
        }
        return Result.failure(ResponseCode.FAIL);
    }

    @PostMapping("/coach/deleteCoach/{coachId}")
    public Result deleteCoach(@PathVariable("coachId") Integer coachId){
        int result = coachService.deleteCoach(coachId);
        if(result!=-1){
            return Result.success();
        }else {
            return  Result.failure(ResponseCode.FAIL);
        }
    }


    @PostMapping("/coach/updateCoach")
    public Result updateCoach(Coach coach){
        int result = coachService.updateCoach(coach);
        if(result!=-1){
            return Result.success();
        }else {
            return  Result.failure(ResponseCode.FAIL);
        }
    }
    @PostMapping("/coach/login")
    public Result coachLogin(HttpServletRequest request) throws
            IOException {
        Coach coach=new ObjectMapper().readValue(request.getInputStream(), Coach.class);
        return coachService.login(coach);
    }


}
