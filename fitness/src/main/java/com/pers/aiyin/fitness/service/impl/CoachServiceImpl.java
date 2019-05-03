package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.entity.CoachExample;
import com.pers.aiyin.fitness.mapper.CoachMapper;
import com.pers.aiyin.fitness.service.CoachService;
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


}
