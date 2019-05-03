package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.ClubCard;
import com.pers.aiyin.fitness.entity.ClubCardExample;
import com.pers.aiyin.fitness.mapper.ClubCardMapper;
import com.pers.aiyin.fitness.service.ClubCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubCardServiceImpl implements ClubCardService {

    @Autowired
    public ClubCardMapper clubCardMapper;

    @Override
    public  PageInfo<ClubCard> getCardList(int pageCurrent, int pageSize){
          ClubCardExample example = new ClubCardExample();
          PageHelper.startPage(pageCurrent,pageSize);
          List<ClubCard> list = clubCardMapper.selectByExample(example);
          PageInfo<ClubCard> pageInfo = new PageInfo<>(list);
          return pageInfo;
    }
    @Override
    public int addCoach(ClubCard clubCard){
          return clubCardMapper.insertSelective(clubCard);
    }
    @Override
    public ClubCard getCoach(Integer cardId){
      return clubCardMapper.selectByPrimaryKey(cardId);
    }
    @Override
    public int deleteCoach(Integer cardId){
      return clubCardMapper.deleteByPrimaryKey(cardId);
    }
    @Override
    public int updateCoach(ClubCard clubCard){
      return clubCardMapper.updateByPrimaryKeySelective(clubCard);
    }
}
