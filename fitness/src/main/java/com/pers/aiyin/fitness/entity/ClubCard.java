package com.pers.aiyin.fitness.entity;

import java.io.Serializable;

public class ClubCard implements Serializable {
    private Integer cardId;

    private String cardName;

    private Byte cardType;

    private Double price;

    private static final long serialVersionUID = 1L;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public Byte getCardType() {
        return cardType;
    }

    public void setCardType(Byte cardType) {
        this.cardType = cardType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}