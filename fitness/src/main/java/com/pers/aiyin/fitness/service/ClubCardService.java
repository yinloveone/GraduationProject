package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.ClubCard;

public interface ClubCardService {
    PageInfo<ClubCard> getCardList(int pageCurrent, int pageSize);

    int addClubCard(ClubCard clubCard);

    ClubCard getClubCard(Integer cardId);

    int deleteClubCard(Integer cardId);

    int updateClubCard(ClubCard clubCard);
}
