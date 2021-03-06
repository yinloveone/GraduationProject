package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.*;
import com.pers.aiyin.fitness.mapper.*;
import com.pers.aiyin.fitness.response.CustomCourse;
import com.pers.aiyin.fitness.service.CourseService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private OptionListMapper optionListMapper;

    @Autowired
    private CourseRecordMapper courseRecordMapper;

    @Autowired
    private CustomCourseRecordMapper customCourseRecordMapper;

    @Autowired
    private PrivateCourseMapper privateCourseMapper;

    @Override
    public PageInfo<CustomCourse> getCourseList(int pageCurrent, int pageSize,CustomCourse course){

        PageHelper.startPage(pageCurrent,pageSize);
        List<CustomCourse> list = customCourseRecordMapper.getCourseList(course);
        PageInfo<CustomCourse> pageInfo =new PageInfo<>(list);
        return pageInfo;
    }
    /*
    * 验证教练时间的安排，教室的是否被占用
    * */
    public Result addCourse(Course course){
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria c=courseExample.createCriteria();
        c.andCoachIdEqualTo(course.getCoachId());
        c.andCourseTimeStartLessThanOrEqualTo(course.getCourseTimeStart());
        c.andCourseTimeEndGreaterThanOrEqualTo(course.getCourseTimeStart());

        CourseExample.Criteria c1=courseExample.createCriteria();
        c1.andCoachIdEqualTo(course.getCoachId());
        c1.andCourseTimeStartLessThanOrEqualTo(course.getCourseTimeEnd());
        c1.andCourseTimeEndGreaterThanOrEqualTo(course.getCourseTimeEnd());
        courseExample.or(c);
        courseExample.or(c1);

        List<Course> list = courseMapper.selectByExample(courseExample);
        if(list!=null&&list.size()>0){
            System.out.println("*************"+list.size());
            return new Result(1,"教练时间有冲突");
        }else{
            courseExample = new CourseExample();
            CourseExample.Criteria c2=courseExample.createCriteria();
            c2.andCoachIdEqualTo(course.getCoachId());
            c2.andCourseTimeStartLessThanOrEqualTo(course.getCourseTimeStart());
            c2.andCourseTimeStartGreaterThanOrEqualTo(course.getCourseTimeStart());
            CourseExample.Criteria c3=courseExample.createCriteria();
            c3.andCoachIdEqualTo(course.getCoachId());
            c3.andCourseTimeStartLessThanOrEqualTo(course.getCourseTimeEnd());
            c3.andCourseTimeStartGreaterThanOrEqualTo(course.getCourseTimeEnd());
            courseExample.or(c2);
            courseExample.or(c3);
            List<Course> list1 = courseMapper.selectByExample(courseExample);
            if(list1!=null&&list1.size()>0){
                return new Result(1,"教室被占用！");
            }else{
               int result = courseMapper.insertSelective(course);
                if(result != -1){
                    return Result.success();
                }else {
                    return  Result.failure(ResponseCode.FAIL);
                }
            }


        }


    }

    public Course getCourse(Integer courseId){
        return courseMapper.selectByPrimaryKey(courseId);
    }

    public Result deleteCourse(Course course){
        CourseRecordExample example =new CourseRecordExample();
        CourseRecordExample.Criteria criteria=example.createCriteria();
        criteria.andCourseIdEqualTo(course.getCourseId());
        List<CourseRecord> list=courseRecordMapper.selectByExample(example);
        if(null!=list&&list.size()>0){
            return new Result(1,"已有学员选课，不能删除！");
        }else{
            int count= courseMapper.updateByPrimaryKeySelective(course);
            if(count>0){
                return Result.success();
            }
            return Result.failure(ResponseCode.FAIL);
        }


    }

    public int updateCourse(Course course){
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    public List<Coach> getCoachList(){
    return optionListMapper.getCoachList();
    }


    public List<ClassRoom> getRoomList(){
      return optionListMapper.getRoomList();
    }
    public Result getPrivateList(Integer coachId){
        Map<String,Object> map = new HashMap<>();
        map.put("coachId",coachId);
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.set(Calendar.DATE, now.get(Calendar.DATE) + 2);
        map.put("courseTime",now.getTime());
        List<CustomCourse> list=privateCourseMapper.getPrivateList(map);
        if(null!=list&&list.size()>0){
            return Result.success(list);
        }else{
            return Result.failure(ResponseCode.FAIL);
        }

    }
}
