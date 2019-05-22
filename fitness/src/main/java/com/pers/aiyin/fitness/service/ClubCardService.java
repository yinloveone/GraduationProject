package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.ClubCard;
import com.pers.aiyin.fitness.utils.Result;

import javax.smartcardio.Card;

public interface ClubCardService {
    PageInfo<ClubCard> getCardList(int pageCurrent, int pageSize, ClubCard card);

    Result addClubCard(ClubCard clubCard);

    ClubCard getClubCard(Integer cardId);

    Result deleteClubCard(ClubCard clubCard);

    Result updateClubCard(ClubCard clubCard);
}
