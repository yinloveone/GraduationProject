package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.entity.WeightRecord;
import com.pers.aiyin.fitness.mapper.WeightMapper;
import com.pers.aiyin.fitness.mapper.WeightRecordMapper;
import com.pers.aiyin.fitness.response.CustomWeightRecord;
import com.pers.aiyin.fitness.service.WeightService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WeightServiceImpl implements WeightService {

    @Autowired
    private WeightMapper weightMapper;

    @Autowired
    private WeightRecordMapper weightRecordMapper;

    @Override
    public Result getWeightList(Integer stuId){
        List<CustomWeightRecord> list= weightMapper.getWeightList(stuId);
        if(null!=list&&list.size()>0){
            return Result.success(list);
        }else{
            return new Result(1,"没有记录的体重");
        }

    }

    @Override
    public Result addWeight(WeightRecord weightRecord){
        weightRecord.setRecordTime(new Date());
        int result = weightRecordMapper.insertSelective(weightRecord);
        if(result<1){
            return Result.success();
        }else{
            return Result.failure(ResponseCode.FAIL);
        }

    }

}
