package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.entity.CourseExample;
import com.pers.aiyin.fitness.entity.CourseRecord;
import com.pers.aiyin.fitness.entity.CourseRecordExample;
import com.pers.aiyin.fitness.mapper.CourseMapper;
import com.pers.aiyin.fitness.mapper.CourseRecordMapper;
import com.pers.aiyin.fitness.mapper.custom.CustomCourseRecordMapper;
import com.pers.aiyin.fitness.response.CustomCourseRecord;
import com.pers.aiyin.fitness.service.CourseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseRecordServiceImpl implements CourseRecordService {

    @Autowired
    private CourseRecordMapper courseRecordMapper;

    @Autowired
    private CustomCourseRecordMapper customCourseRecordMapper;

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<CustomCourseRecord> getRecordByStuId(Integer stuId){
        return customCourseRecordMapper.getRecordByStuId(stuId);
    }
    public List<CustomCourseRecord> getRecordByCoachId(Integer coachId){
        return customCourseRecordMapper.getRecordByCoachId(coachId);
    }

    public String orderCourse(CourseRecord courseRecord){
        Course course = courseMapper.selectByPrimaryKey(courseRecord.getCourseId());
        if (null==course){
            return "课程不存在";
        }else if(course.getCourseSurplus()<1){
            return "课程已被预约完";
        }else{
            CourseRecordExample example=new CourseRecordExample();
            CourseRecordExample.Criteria criteria=example.createCriteria();
            criteria.andCourseIdEqualTo(courseRecord.getCourseId());
            criteria.andStuIdEqualTo(courseRecord.getStuId());
            List<CourseRecord> record = courseRecordMapper.selectByExample(example);
            if(null!=record&&record.size()!=0)
                return "已经预约过此课程";
            else{
               int count = courseRecordMapper.insertSelective(courseRecord);
               course.setCourseSurplus(course.getCourseSurplus()-1);
               int updateCount = courseMapper.updateByPrimaryKeySelective(course);

               if(count>0&&updateCount>0)
                return "预约成功";
               else
                   return "发生意外错误,请联系管理员";
            }



        }

    }
}
