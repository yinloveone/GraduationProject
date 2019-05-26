package com.pers.aiyin.fitness.response;

import lombok.Data;

import java.util.Date;

@Data
public class CustomStudent {
    private Integer stuId;

    private String stuName;

    private String password;

    private Integer age;

    private Byte sex;

    private String email;

    private String phone;

    private Double height;

    private Double weight;

    private Date birthday;

    private Integer cardId;

    private String cardName;

    private String studentPortrait;
}
