package com.pers.aiyin.fitness.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pers.aiyin.fitness.entity.ClubCard;

import com.pers.aiyin.fitness.service.ClubCardService;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
public class CardController {
    @Autowired
    private ClubCardService clubCardService;

    @PostMapping("/card/CardList")
    public String CardList(Integer rows, Integer page, ClubCard card){
        Map<String,Object> resultMap=new HashMap<>();
        PageInfo<ClubCard> pageInfo = clubCardService.getCardList(page,rows,card);
        resultMap.put("rows",pageInfo.getList());
        resultMap.put("total",pageInfo.getTotal());
        return new Gson().toJson(resultMap);
    }
    @PostMapping("/card/deleteCard")
    public Result deleteCard(ClubCard card){

        return clubCardService.deleteClubCard(card);
    }
    @PostMapping("/card/addCard")
    public Result addCard(ClubCard clubCard){

        return clubCardService.addClubCard(clubCard);
    }
    @PostMapping("card/updateCard")
    public Result update(ClubCard clubCard){

        return clubCardService.updateClubCard(clubCard);
    }
    @GetMapping("/card/getCard/{CardId}")
    public Result getCard(@PathVariable("CardId") Integer CardId){
        return clubCardService.getClubCard(CardId);
    }

    @GetMapping("/card/getByStuId/{stuId}")
    public Result getByStuId(@PathVariable("stuId") Integer stuId){
        return clubCardService.getByStuId(stuId);
    }

}
