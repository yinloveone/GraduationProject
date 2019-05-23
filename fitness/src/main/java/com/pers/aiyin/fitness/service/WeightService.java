package com.pers.aiyin.fitness.service;

import com.pers.aiyin.fitness.entity.WeightRecord;
import com.pers.aiyin.fitness.utils.Result;

public interface WeightService {
    Result getWeightList(Integer stuId);
    Result addWeight(WeightRecord weightRecord);
}
