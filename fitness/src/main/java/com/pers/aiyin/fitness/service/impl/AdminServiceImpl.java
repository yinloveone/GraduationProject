package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.entity.Admin;
import com.pers.aiyin.fitness.mapper.AdminMapper;
import com.pers.aiyin.fitness.service.AdminService;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public Result login(Admin admin, HttpServletRequest request){
        Admin admin1=adminMapper.getByName(admin.getName());
        if(null==admin1){
            return new Result(404,"用户名不存在");
        }else{
            Admin admin2=adminMapper.login(admin);
            if(null==admin2){
                return new Result(200,"密码错误");
            }else{
                HttpSession session=request.getSession();
                session.setAttribute("admin",admin2);
                return Result.success(admin2);
            }
        }
    }


}
