package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.entity.CoachExample;
import com.pers.aiyin.fitness.mapper.CoachMapper;
import com.pers.aiyin.fitness.mapper.CustomCoachMapper;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.service.CoachService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachMapper coachMapper;

    @Autowired
    private CustomCoachMapper customCoachMapper;

    @Override
    public PageInfo<Coach> getCoachList(int pageCurrent, int pageSize,Coach coach){
        CoachExample example = new CoachExample();
        CoachExample.Criteria criteria=example.createCriteria();
        if(null!=coach.getCoachName()&&!"".equals(coach.getCoachName())){
            criteria.andCoachNameLike("%"+coach.getCoachName()+"%");
        }
        if(null!=coach.getPhone()&&!"".equals(coach.getPhone())){
            criteria.andPhoneEqualTo(coach.getPhone());
        }
        if(null!=coach.getGrade()){
            criteria.andGradeEqualTo(coach.getGrade());
        }
        PageHelper.startPage(pageCurrent, pageSize);
        List<Coach> list = coachMapper.selectByExample(example);
        PageInfo<Coach> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
    /*
    * 验证电话是否重复
    * */

    @Override
    public Result addCoach(Coach coach){
        CoachExample example = new CoachExample();
        CoachExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(coach.getPhone());
        List<Coach> list = coachMapper.selectByExample(example);
        if(null!=list&&list.size()>0){
            return new Result(1,"电话已经存在！");

        }else {

            int result = coachMapper.insertSelective(coach);

            if (result != -1) {
                return Result.success();
            } else {
                return Result.failure(ResponseCode.FAIL);
            }
        }
    }

    @Override
    public Coach getCoach(Integer coachId){
        return coachMapper.selectByPrimaryKey(coachId);
    }

    @Override
    public int deleteCoach(Integer coachId){
        return coachMapper.deleteByPrimaryKey(coachId);
    }

    @Override
    public int updateCoach(Coach coach){
        return coachMapper.updateByPrimaryKey(coach);
    }

    @Override
    public Result login(Coach coach){
        CoachExample example = new CoachExample();
        CoachExample.Criteria criteria = example.createCriteria();
        criteria.andCoachNameEqualTo(coach.getCoachName());
        List<Coach> coach1= coachMapper.selectByExample(example);
        if(coach1!=null||coach1.size()>0){
            criteria.andPasswordEqualTo(coach.getPassword());
            List<Coach> coach2= coachMapper.selectByExample(example);
            if(coach2!=null||coach2.size()>0) {
                return Result.success(coach2.get(0));
            }else{
                return new Result(1,"密码错误");
            }

        }else{
            return new Result(404,"用户名不存在");
        }
    }

    @Override
    public Result getStudentList(Integer coachId){
        List<CustomStudent> list = customCoachMapper.StuListByCoachId(coachId);
        if(null!=list&&list.size()>0){
            return Result.success(list);
        }else{
            return Result.failure(ResponseCode.FAIL);
        }
    }


}
