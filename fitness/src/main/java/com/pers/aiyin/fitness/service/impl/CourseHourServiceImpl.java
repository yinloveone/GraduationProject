package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.entity.CourseHour;
import com.pers.aiyin.fitness.entity.CourseHourExample;
import com.pers.aiyin.fitness.mapper.CourseHourMapper;
import com.pers.aiyin.fitness.service.CourseHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseHourServiceImpl implements CourseHourService {

    @Autowired
    private CourseHourMapper courseHourMapper;

    @Override
    public List<CourseHour> getByStuId(Integer stuId){
        CourseHourExample example = new CourseHourExample();
        CourseHourExample.Criteria criteria=example.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        return courseHourMapper.selectByExample(example);

    }
}
