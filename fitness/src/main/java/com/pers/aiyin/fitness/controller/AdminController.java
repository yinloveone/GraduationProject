package com.pers.aiyin.fitness.controller;

import com.pers.aiyin.fitness.entity.Admin;
import com.pers.aiyin.fitness.service.AdminService;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("api")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @GetMapping("/login")
    public String  getLogin(){
        return "login/login";
    }

    @GetMapping("/coachManage")
    public String getCoachManage(){return "coachManage";}

    @GetMapping("/courseManage")
    public String getCourseManage(){
        return "courseManage";
    }

    @GetMapping("/cardManage")
    public String getCardManage(){
        return "cardManage";
    }

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/loginPage")
    public String adminLogin(HttpServletRequest request){
      String name =  request.getParameter("name");
      String password = request.getParameter("password");
      Admin admin=new Admin();
      admin.setName(name);
      admin.setPassword(password);
      Result result = adminService.login(admin,request);
      if(result.getCode()==0){
          return "index";
      }else {
          return "index";
      }


    }
}
