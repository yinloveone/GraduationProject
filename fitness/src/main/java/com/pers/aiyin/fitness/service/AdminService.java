package com.pers.aiyin.fitness.service;

import com.pers.aiyin.fitness.entity.Admin;
import com.pers.aiyin.fitness.utils.Result;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {
    Result login(Admin admin,HttpServletRequest request);

}
