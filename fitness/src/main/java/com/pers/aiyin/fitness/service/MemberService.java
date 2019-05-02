package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.response.CustomStudent;


public interface MemberService {
    PageInfo<CustomStudent> getStudentList(int pageCurrent, int pageSize);
}
