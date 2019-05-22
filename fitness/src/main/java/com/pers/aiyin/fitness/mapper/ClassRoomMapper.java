package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.ClassRoom;
import com.pers.aiyin.fitness.entity.ClassRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassRoomMapper {
    long countByExample(ClassRoomExample example);

    int deleteByExample(ClassRoomExample example);

    int deleteByPrimaryKey(Integer roomId);

    int insert(ClassRoom record);

    int insertSelective(ClassRoom record);

    List<ClassRoom> selectByExample(ClassRoomExample example);

    ClassRoom selectByPrimaryKey(Integer roomId);

    int updateByExampleSelective(@Param("record") ClassRoom record, @Param("example") ClassRoomExample example);

    int updateByExample(@Param("record") ClassRoom record, @Param("example") ClassRoomExample example);

    int updateByPrimaryKeySelective(ClassRoom record);

    int updateByPrimaryKey(ClassRoom record);
}