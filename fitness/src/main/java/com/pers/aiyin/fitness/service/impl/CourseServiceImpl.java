package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.ClassRoom;
import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.entity.CourseExample;
import com.pers.aiyin.fitness.mapper.CourseMapper;
import com.pers.aiyin.fitness.mapper.OptionListMapper;
import com.pers.aiyin.fitness.service.CourseService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private OptionListMapper optionListMapper;

    public PageInfo<Course> getCourseList(int pageCurrent, int pageSize,Course course){
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria=courseExample.createCriteria();
        if(null!=course.getCoachName()&&!"".equals(course.getCoachName())){
            criteria.andCoachNameLike("%"+course.getCoachName()+"%");
        }
        if(null!=course.getCourseName()&&!"".equals(course.getCourseName())){
            criteria.andCourseNameLike("%"+course.getCourseName()+"%");
        }
        if(null!=course.getRoomName()&&!"".equals(course.getRoomName())){
            criteria.andRoomNameLike("%"+course.getRoomName()+"%");
        }
        if(null!=course.getCourseTimeStart()){
            criteria.andCourseTimeStartEqualTo(course.getCourseTimeStart());
        }
        criteria.andIsDeleteEqualTo(new Byte("0"));

        PageHelper.startPage(pageCurrent,pageSize);
        List<Course> list = courseMapper.selectByExample(courseExample);
        PageInfo<Course> pageInfo =new PageInfo<>(list);
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
        c.andCourseTimeStartGreaterThanOrEqualTo(course.getCourseTimeStart());
        CourseExample.Criteria c1=courseExample.createCriteria();
        c1.andCoachIdEqualTo(course.getCoachId());
        c1.andCourseTimeStartLessThanOrEqualTo(course.getCourseTimeEnd());
        c1.andCourseTimeStartGreaterThanOrEqualTo(course.getCourseTimeEnd());
        courseExample.or(c);
        courseExample.or(c1);

        List<Course> list = courseMapper.selectByExample(courseExample);
        if(list!=null||list.size()>0){
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
            if(list1!=null||list1.size()>0){
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

    public int deleteCourse(Integer courseId){
        return courseMapper.deleteByPrimaryKey(courseId);
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
}
