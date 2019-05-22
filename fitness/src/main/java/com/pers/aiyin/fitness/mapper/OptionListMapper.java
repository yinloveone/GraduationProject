package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.ClassRoom;
import com.pers.aiyin.fitness.entity.Coach;

import java.util.List;

public interface OptionListMapper {
    List<Coach> getCoachList();
    List<ClassRoom> getRoomList();

}
