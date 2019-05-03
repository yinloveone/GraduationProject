package com.pers.aiyin.fitness.mapper.custom;

import com.pers.aiyin.fitness.entity.User;

public interface UserDao {

    String login(User user);

    int insert(User user);

}
