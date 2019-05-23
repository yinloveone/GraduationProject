package com.pers.aiyin.fitness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pers.aiyin.fitness.entity.WeightRecord;
import com.pers.aiyin.fitness.service.WeightService;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("api")
public class WeightController {

    @Autowired
    private WeightService weightService;

    /*
    * 根据stuId获取体重记录
    * */
    @GetMapping("/weight/getWeightList/{stuId}")
    public Result getWeightList(@PathVariable("stuId") Integer stuId){
        return weightService.getWeightList(stuId);
    }

    /*
    * 记录体重
    * */
    @PostMapping("/weight/insertWeight")
    public Result addWeight(HttpServletRequest request) throws
            IOException {
        WeightRecord weightRecord = new ObjectMapper().readValue(request.getInputStream(),WeightRecord.class);
        return weightService.addWeight(weightRecord);
    }

}
