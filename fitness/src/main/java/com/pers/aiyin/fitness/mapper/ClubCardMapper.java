package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.ClubCard;
import com.pers.aiyin.fitness.entity.ClubCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClubCardMapper {
    long countByExample(ClubCardExample example);

    int deleteByExample(ClubCardExample example);

    int deleteByPrimaryKey(Integer cardId);

    int insert(ClubCard record);

    int insertSelective(ClubCard record);

    List<ClubCard> selectByExample(ClubCardExample example);

    ClubCard selectByPrimaryKey(Integer cardId);

    int updateByExampleSelective(@Param("record") ClubCard record, @Param("example") ClubCardExample example);

    int updateByExample(@Param("record") ClubCard record, @Param("example") ClubCardExample example);

    int updateByPrimaryKeySelective(ClubCard record);

    int updateByPrimaryKey(ClubCard record);
}