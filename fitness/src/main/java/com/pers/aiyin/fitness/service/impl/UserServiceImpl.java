package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.mapper.custom.UserMapper;
import com.pers.aiyin.fitness.entity.User;
import com.pers.aiyin.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    public String login(User user){

        return userDao.login(user);
    }
    public int register(User u){

        return userDao.insert(u);
    }
    public List<Course> getCourse(){
        Map<String,Object> map=new HashMap<>();
        Calendar now =Calendar.getInstance();
        now.setTime(new Date());
        now.set(Calendar.DATE,now.get(Calendar.DATE)+2);
        map.put("beginDate",now.getTime());
        map.put("courseType",1);
        return userDao.getCourse(map);
    }
}
