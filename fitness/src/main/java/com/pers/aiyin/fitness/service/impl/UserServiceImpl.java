package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.mapper.custom.UserDao;
import com.pers.aiyin.fitness.entity.User;
import com.pers.aiyin.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public String login(User user){

        return userDao.login(user);
    }
    public int register(User u){

        return userDao.insert(u);
    }
}
