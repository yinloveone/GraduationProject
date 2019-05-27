package com.pers.aiyin.fitness.response;

import lombok.Data;

import java.util.Date;

@Data
public class CustomCoach {
    private Integer coachId;
    private String coachName;
    private String phone;
    private String password;
    private String gradeStr;
    private Date birthday;
    private String sex;
    private String birthdayStr;
    private String coachPortrait;
}
