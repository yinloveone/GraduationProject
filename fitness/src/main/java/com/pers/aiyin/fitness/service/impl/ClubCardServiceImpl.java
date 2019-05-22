package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.ClubCard;
import com.pers.aiyin.fitness.entity.ClubCardExample;
import com.pers.aiyin.fitness.mapper.ClubCardMapper;
import com.pers.aiyin.fitness.service.ClubCardService;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;
import java.util.List;

@Service
public class ClubCardServiceImpl implements ClubCardService {

    @Autowired
    public ClubCardMapper clubCardMapper;

    @Override
    public  PageInfo<ClubCard> getCardList(int pageCurrent, int pageSize, ClubCard card){
          ClubCardExample example = new ClubCardExample();
          ClubCardExample.Criteria criteria =example.createCriteria();
          if(null!=card.getCardName()&&!"".equals(card.getCardName())){
            criteria.andCardNameLike("%"+card.getCardName()+"%");
          }
          if(null!=card.getIsValid()){
              criteria.andIsValidEqualTo(card.getIsValid());
          }
          criteria.andIsDeleteEqualTo(new Byte("0"));
          PageHelper.startPage(pageCurrent,pageSize);
          List<ClubCard> list = clubCardMapper.selectByExample(example);
          PageInfo<ClubCard> pageInfo = new PageInfo<>(list);
          return pageInfo;
    }
    @Override
    public Result addClubCard(ClubCard clubCard){
        int result = clubCardMapper.insertSelective(clubCard);
        if(result<1){
            return new Result(1,"增加失败");
        }
        return Result.success();
    }
    @Override
    public ClubCard getClubCard(Integer cardId){
      return clubCardMapper.selectByPrimaryKey(cardId);
    }
    @Override
    public Result deleteClubCard(ClubCard clubCard){
      int result = clubCardMapper.updateByPrimaryKeySelective(clubCard);
      if(result<1){
          return new Result(1,"删除失败");
      }
      return Result.success();
    }
    @Override
    public Result updateClubCard(ClubCard clubCard){
        int result = clubCardMapper.updateByPrimaryKeySelective(clubCard);
        if(result<1){
            return new Result(1,"更新失败");
        }
        return Result.success();
    }
}
