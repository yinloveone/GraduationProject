package com.pers.aiyin.fitness.response;

import lombok.Data;

@Data
public class CustomCard {
    private Integer stuId;

    private Integer cardId;

    private String cardName;

    private String stuName;

    private Byte cardType;

    private Double price;

    private String restDateStr;

    private String dueDateStr;

    private String studentPortrait;
}
