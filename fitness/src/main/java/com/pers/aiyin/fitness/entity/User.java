package com.pers.aiyin.fitness.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private int age;
    private int sex;
    private String birthday;
}
