package com.pers.aiyin.fitness.service;

import com.pers.aiyin.fitness.entity.User;

public interface UserService {
     String login(User user);
     int register(User user);
}
