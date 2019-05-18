package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.WeightRecord;
import com.pers.aiyin.fitness.entity.WeightRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeightRecordMapper {
    long countByExample(WeightRecordExample example);

    int deleteByExample(WeightRecordExample example);

    int deleteByPrimaryKey(Integer weiRecordId);

    int insert(WeightRecord record);

    int insertSelective(WeightRecord record);

    List<WeightRecord> selectByExample(WeightRecordExample example);

    WeightRecord selectByPrimaryKey(Integer weiRecordId);

    int updateByExampleSelective(@Param("record") WeightRecord record, @Param("example") WeightRecordExample example);

    int updateByExample(@Param("record") WeightRecord record, @Param("example") WeightRecordExample example);

    int updateByPrimaryKeySelective(WeightRecord record);

    int updateByPrimaryKey(WeightRecord record);
}