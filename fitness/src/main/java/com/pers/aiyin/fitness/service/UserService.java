package com.pers.aiyin.fitness.service;

import com.pers.aiyin.fitness.entity.User;

public interface UserService {
     String login(String name,String password);
     int register(User user);
}
