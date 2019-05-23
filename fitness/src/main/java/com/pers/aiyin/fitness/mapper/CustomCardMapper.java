package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.response.CustomCard;

import java.util.List;

public interface CustomCardMapper {
    List<CustomCard>  getByStuId(Integer stuId);
}
