package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.CourseHour;
import com.pers.aiyin.fitness.entity.CourseHourExample;
import com.pers.aiyin.fitness.mapper.CourseHourMapper;
import com.pers.aiyin.fitness.mapper.CustomCourseHourMapper;
import com.pers.aiyin.fitness.response.CustomCourseHour;
import com.pers.aiyin.fitness.service.CourseHourService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseHourServiceImpl implements CourseHourService {

    @Autowired
    private CourseHourMapper courseHourMapper;

    @Autowired
    private CustomCourseHourMapper customCourseHourMapper;

    @Override
    public List<CustomCourseHour> getByStuId(Integer stuId){
        return customCourseHourMapper.getHourById(stuId);

    }
    @Override
    public Result addCourseHour(CourseHour courseHour){
        CourseHourExample example=new CourseHourExample();
        CourseHourExample.Criteria criteria=example.createCriteria();
        criteria.andCoachIdEqualTo(courseHour.getCoachId());
        criteria.andStuIdEqualTo(courseHour.getStuId());
        criteria.andHourCountGreaterThan(0);
        List<CourseHour> list=courseHourMapper.selectByExample(example);
        if(null==list||list.size()==0){
            int count=courseHourMapper.insertSelective(courseHour);;
            if(count>0){
                return Result.success();
            }
            return Result.failure(ResponseCode.FAIL);

        }else{
            return new Result(1,"课时已存在");
        }
    }

    @Override
    public PageInfo<CustomCourseHour> getHourList(int pageCurrent, int pageSize, CustomCourseHour customCourseHour){
        PageHelper.startPage(pageCurrent,pageSize);
        List<CustomCourseHour> list = customCourseHourMapper.getHourList(customCourseHour);
        PageInfo<CustomCourseHour> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}
