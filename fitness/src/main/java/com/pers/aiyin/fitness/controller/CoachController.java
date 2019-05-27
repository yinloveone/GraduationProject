package com.pers.aiyin.fitness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.response.CustomCoach;
import com.pers.aiyin.fitness.response.PrivateCourse;
import com.pers.aiyin.fitness.service.CoachService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
    public String getCoachList(Integer rows, Integer page,Coach coach){
        Map<String,Object> resultMap=new HashMap<>();
        PageInfo<Coach> pageInfo = coachService.getCoachList(page,rows,coach);
        resultMap.put("rows",pageInfo.getList());
        resultMap.put("total",pageInfo.getTotal());
        return new Gson().toJson(resultMap);
    }

    @PostMapping("/coach/addCoach")
    public Result addCoach(Coach coach){
        return coachService.addCoach(coach);
    }

    @GetMapping("/coach/getCoach/{coachId}")
    public Result getCoach(@PathVariable("coachId") Integer coachId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Coach coach = coachService.getCoach(coachId);
        if(null!=coach){
            CustomCoach customCoach = new CustomCoach();
            customCoach.setCoachName(coach.getCoachName());
            customCoach.setGrade(coach.getGrade());
            customCoach.setCoachId(coach.getCoachId());
            customCoach.setBirthdayStr(sdf.format(coach.getBirthday()));
            customCoach.setPhone(coach.getPhone());
            if(coach.getGrade()==1){
                customCoach.setGradeStr("初级");
            }else if(coach.getGrade()==2){
                customCoach.setGradeStr("中级");
            }else{
                customCoach.setGradeStr("高级");
            }
            if(coach.getSex()==1){
                customCoach.setSex("女");
            }else{
                customCoach.setSex("男");
            }
            return Result.success(customCoach);
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

    @PostMapping("/coach/updatePassword")
    public Result updatePassword(HttpServletRequest request) throws
            IOException {
        Coach coach=new ObjectMapper().readValue(request.getInputStream(), Coach.class);
        int result = coachService.updateCoach(coach);
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
    @GetMapping("/coach/getStudent/{coachId}")
    public Result getStudentList(@PathVariable("coachId") Integer coachId){
        return coachService.getStudentList(coachId);
    }


}
