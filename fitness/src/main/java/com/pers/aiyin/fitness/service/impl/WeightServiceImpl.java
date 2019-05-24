package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.entity.WeightRecord;
import com.pers.aiyin.fitness.entity.WeightRecordExample;
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
        WeightRecordExample example=new WeightRecordExample();
        WeightRecordExample.Criteria criteria=example.createCriteria();
        criteria.andStuIdEqualTo(weightRecord.getStuId());
        criteria.andRecordTimeEqualTo(weightRecord.getRecordTime());
        List<WeightRecord> list=weightRecordMapper.selectByExample(example);
        if(null!=list&&list.size()>0){
            return new Result(1,"今天已经记录过体重");
        }else {
            int result = weightRecordMapper.insertSelective(weightRecord);

            if (result < 1) {
                return Result.failure(ResponseCode.FAIL);
            } else {
                return Result.success();
            }
        }

    }

}
