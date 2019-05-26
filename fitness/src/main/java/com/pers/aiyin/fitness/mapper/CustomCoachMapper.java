package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.response.CustomStudent;

import java.util.List;

public interface CustomCoachMapper {
    List<CustomStudent> StuListByCoachId(Integer coachId);
}
