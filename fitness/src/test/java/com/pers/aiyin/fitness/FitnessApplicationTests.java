package com.pers.aiyin.fitness;

import com.pers.aiyin.fitness.response.CourseRecordList;
import com.pers.aiyin.fitness.service.CourseRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FitnessApplicationTests {
    @Autowired
    private CourseRecordService courseRecordService;

    @Test
    public void contextLoads() {
        List<CourseRecordList> courseRecordList = courseRecordService.getRecordByStuId(1);
    }

}
