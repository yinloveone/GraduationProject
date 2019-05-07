package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.entity.*;
import com.pers.aiyin.fitness.mapper.CourseHourMapper;
import com.pers.aiyin.fitness.mapper.CourseMapper;
import com.pers.aiyin.fitness.mapper.CourseRecordMapper;
import com.pers.aiyin.fitness.mapper.CustomCourseRecordMapper;
import com.pers.aiyin.fitness.response.CustomCourseRecord;
import com.pers.aiyin.fitness.service.CourseRecordService;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class CourseRecordServiceImpl implements CourseRecordService {

    @Autowired
    private CourseRecordMapper courseRecordMapper;

    @Autowired
    private CustomCourseRecordMapper customCourseRecordMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseHourMapper courseHourMapper;


    @Override
    public List<CustomCourseRecord> getRecordByStuId(Integer stuId){
        return customCourseRecordMapper.getRecordByStuId(stuId);
    }
    @Override
    public List<CustomCourseRecord> getRecordByCoachId(Integer coachId){
        return customCourseRecordMapper.getRecordByCoachId(coachId);
    }
    @Override
    public Result orderCourse(CourseRecord courseRecord){
        Course course = courseMapper.selectByPrimaryKey(courseRecord.getCourseId());
        if (null==course){
            return new Result(400,"课程不存在");
        }else if(course.getCourseSurplus()<1){
            return new Result(200,"课程已被预约完");
        }else{
            CourseRecordExample example=new CourseRecordExample();
            CourseRecordExample.Criteria criteria=example.createCriteria();
            criteria.andCourseIdEqualTo(courseRecord.getCourseId());
            criteria.andStuIdEqualTo(courseRecord.getStuId());
            List<CourseRecord> record = courseRecordMapper.selectByExample(example);
            if(null!=record&&record.size()!=0)
                return new Result(200,"已经预约过此课程");
            else{
               int count = courseRecordMapper.insertSelective(courseRecord);
               course.setCourseSurplus(course.getCourseSurplus()-1);
               int updateCount = courseMapper.updateByPrimaryKeySelective(course);

               if(course.getCourseType().equals("COACH")){
                   //更新课时
                   CourseHourExample hourExample = new CourseHourExample();
                   CourseHourExample.Criteria criteria1 = hourExample.createCriteria();
                   criteria1.andStuIdEqualTo(courseRecord.getStuId());
                   criteria1.andCoachIdEqualTo(course.getCoachId());
                   List<CourseHour> courseHour=courseHourMapper.selectByExample(hourExample);
                   courseHour.get(0).setHourCount(courseHour.get(0).getHourCount()-1);
                   courseHourMapper.updateByPrimaryKeySelective(courseHour.get(0));

               }
               if(count>0&&updateCount>0)
                return new Result(200,"预约成功");
               else
                   return new Result(500,"发生意外错误,请联系管理员");
            }
        }
    }
    @Override
    public Result cancelOrder(CourseRecord courseRecord){
        Course course = courseMapper.selectByPrimaryKey(courseRecord.getCourseId());
        if (null==course) {
            return new Result(400, "课程不存在");
        }else{

            if(course.getCourseType().equals("COACH")){
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                int day=c.get(Calendar.DATE);
                c.set(Calendar.DATE,day+2);
                Date afterDate=c.getTime();   //后两天的时间
                if(course.getCourseTimeStart().after(afterDate)){
                    CourseHourExample hourExample = new CourseHourExample();
                    CourseHourExample.Criteria criteria1 = hourExample.createCriteria();
                    criteria1.andStuIdEqualTo(courseRecord.getStuId());
                    criteria1.andCoachIdEqualTo(course.getCoachId());
                    List<CourseHour> courseHour=courseHourMapper.selectByExample(hourExample);
                    courseHour.get(0).setHourCount(courseHour.get(0).getHourCount()+1);
                    courseHourMapper.updateByPrimaryKeySelective(courseHour.get(0));
                }
            }
            int count = courseRecordMapper.deleteByPrimaryKey(courseRecord.getCourseRecordId());
            course.setCourseSurplus(course.getCourseSurplus()+1);
            int updateCount = courseMapper.updateByPrimaryKeySelective(course);
            if(count>0&&updateCount>0)
                return new Result(200,"取消成功");
            else
                return new Result(500,"发生意外错误,请联系管理员");

        }
    }


}
