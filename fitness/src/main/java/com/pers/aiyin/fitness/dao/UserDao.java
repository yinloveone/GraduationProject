package com.pers.aiyin.fitness.dao;

import com.pers.aiyin.fitness.entity.User;

public interface UserDao {

    String login(User user);

    int insert(User user);

}
