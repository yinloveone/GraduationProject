package com.pers.aiyin.fitness.response;

import lombok.Data;

@Data
public class CustomCard {
    private Integer stuId;

    private Integer cardId;

    private String cardName;

    private Byte cardType;

    private Double price;
}
