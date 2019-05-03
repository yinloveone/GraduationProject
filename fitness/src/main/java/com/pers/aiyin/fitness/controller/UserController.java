package com.pers.aiyin.fitness.controller;

import com.pers.aiyin.fitness.entity.User;
import com.pers.aiyin.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;


@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/loginPage")
    public Map<String, Object> loginCon(HttpServletRequest request) throws
            IOException {
       Map<String,Object> result=new HashMap<>();
        User user=new ObjectMapper().readValue(request.getInputStream(), User.class);
        String userName=userService.login(user);
        if(null!=userName&&!"".equals(userName)){
            result.put("status", 0);
            result.put("result", userName);
            result.put("msg", "登陆成功");
        }else{
            result.put("status", 1);
            result.put("msg", "请检查你的用户名和密码");
        }
       return result;
    }
    @PostMapping("/register")
    public Map<String, Object> register(HttpServletRequest request) throws IOException{
        Map<String, Object> result = new HashMap<>();
        User user=new ObjectMapper().readValue(request.getInputStream(), User.class);
        int id=userService.register(user);
        if(id!=0){
            result.put("status", 0);
            result.put("result", id);
            result.put("msg", "注册成功");
        }
        else{
            result.put("status", 1);
            result.put("msg", "注册失败");
        }
        return result;

    }
}
