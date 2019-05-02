package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.mapper.custom.CustomStudentMapper;
import com.pers.aiyin.fitness.response.CustomStudent;
import com.pers.aiyin.fitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    private CustomStudentMapper customStudentMapper;

    @Override
    public   PageInfo<CustomStudent> getStudentList(int pageCurrent,int pageSize){
        PageHelper.startPage(pageCurrent, pageSize);
        List<CustomStudent> list =  customStudentMapper.getStudentList();
        PageInfo<CustomStudent> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


}
