package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.response.CustomWeightRecord;

import java.util.List;

public interface WeightMapper {
    List<CustomWeightRecord> getWeightList(Integer stuId);
}
