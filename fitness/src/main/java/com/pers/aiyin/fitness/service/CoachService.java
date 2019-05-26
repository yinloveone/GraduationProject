package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.utils.Result;

public interface CoachService {
    PageInfo<Coach> getCoachList(int pageCurrent, int pageSize,Coach coach);

    Result addCoach(Coach coach);

    Coach getCoach(Integer coachId);

    int deleteCoach(Integer coachId);

    int updateCoach(Coach coach);

    Result login(Coach coach);

    Result getStudentList(Integer coachId);

}
