package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.ClubCard;

public interface ClubCardService {
    PageInfo<ClubCard> getCardList(int pageCurrent, int pageSize);

    int addCoach(ClubCard clubCard);

    ClubCard getCoach(Integer cardId);

    int deleteCoach(Integer cardId);

    int updateCoach(ClubCard clubCard);
}
