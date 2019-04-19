package com.pers.aiyin.fitness.controller;

import com.pers.aiyin.fitness.entity.User;
import com.pers.aiyin.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginPage")
    public void loginCon(HttpServletRequest request, HttpServletResponse response) throws
            IOException {
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String result=userService.login(name,password);
        if(null!=result)
            response.getOutputStream().write((name )
                    .getBytes("utf-8"));
        else
        response.getOutputStream().write(("fail").getBytes("utf-8"));
    }
    @PostMapping("/register")
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String result;
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        int id=userService.register(user);
        PrintWriter out = response.getWriter();
        if(id!=0){
            result = "success";
        }
        else{
            result = "fail";
        }
        out.write(result);
        out.flush();
        out.close();

    }

}
