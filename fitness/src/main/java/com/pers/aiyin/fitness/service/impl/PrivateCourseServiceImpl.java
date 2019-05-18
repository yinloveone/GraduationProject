package com.pers.aiyin.fitness.service.impl;

import com.pers.aiyin.fitness.mapper.PrivateCourseMapper;
import com.pers.aiyin.fitness.response.PrivateCourse;
import com.pers.aiyin.fitness.service.PrivateCourseService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PrivateCourseServiceImpl implements PrivateCourseService {

    @Autowired
    private PrivateCourseMapper privateCourseMapper;


    public Result getPrivateCourse(PrivateCourse privateCourse){
        List<Integer> listId = privateCourseMapper.getCoachId(privateCourse.getStuId());
        if(null!=listId&&listId.size()>0) {
            Map<String, Object> map = new HashMap<>();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(privateCourse.getCourseTimeStart().getTime()), ZoneId.systemDefault());
            LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
            LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
            Date beginDate = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
            Date endDate = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            map.put("courseType", "COACH");
            map.put("idList", listId);
            List<PrivateCourse> list = privateCourseMapper.getPrivateCourse(map);
            if (null!=list&&list.size()>0){
                return Result.success(list);
            }else{
                return Result.failure(ResponseCode.FAIL);
            }
        }else
            return Result.failure(ResponseCode.FAIL);
    }
}
