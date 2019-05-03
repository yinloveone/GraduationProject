package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.DietRecord;
import com.pers.aiyin.fitness.entity.DietRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DietRecordMapper {
    long countByExample(DietRecordExample example);

    int deleteByExample(DietRecordExample example);

    int deleteByPrimaryKey(Integer dietId);

    int insert(DietRecord record);

    int insertSelective(DietRecord record);

    List<DietRecord> selectByExample(DietRecordExample example);

    DietRecord selectByPrimaryKey(Integer dietId);

    int updateByExampleSelective(@Param("record") DietRecord record, @Param("example") DietRecordExample example);

    int updateByExample(@Param("record") DietRecord record, @Param("example") DietRecordExample example);

    int updateByPrimaryKeySelective(DietRecord record);

    int updateByPrimaryKey(DietRecord record);
}