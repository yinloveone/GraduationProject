package com.pers.aiyin.fitness.controller;

import com.pers.aiyin.fitness.entity.User;
import com.pers.aiyin.fitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String  getIndex(){
        return "login/login";
    }
    @PostMapping("/loginPage")
    public String adminLogin(String name,String password){
        /*User user=new User();
        user.setName(name);
        user.setPassword(password);
        String userName =  adminService.adminLogin(user);
        if(null!=userName&&!"".equals(userName))
        return "index";
        else*/ return "index";

    }
}
