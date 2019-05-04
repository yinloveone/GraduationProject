package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.mapper.custom.UserMapper;
import com.pers.aiyin.fitness.entity.User;
import com.pers.aiyin.fitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserMapper userDao;

    public String adminLogin(User user){

        return userDao.login(user);
    }
}
