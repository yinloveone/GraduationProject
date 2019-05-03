package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Coach;

public interface CoachService {
    PageInfo<Coach> getCoachList(int pageCurrent, int pageSize);

    int addCoach(Coach coach);

    Coach getCoach(Integer coachId);

    int deleteCoach(Integer coachId);

    int updateCoach(Coach coach);

}
