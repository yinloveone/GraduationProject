package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.entity.CoachExample;
import com.pers.aiyin.fitness.mapper.CoachMapper;
import com.pers.aiyin.fitness.service.CoachService;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachMapper coachMapper;

    @Override
    public PageInfo<Coach> getCoachList(int pageCurrent, int pageSize){
        CoachExample example = new CoachExample();
        PageHelper.startPage(pageCurrent, pageSize);
        List<Coach> list = coachMapper.selectByExample(example);
        PageInfo<Coach> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addCoach(Coach coach){
        return coachMapper.insertSelective(coach);
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


}
