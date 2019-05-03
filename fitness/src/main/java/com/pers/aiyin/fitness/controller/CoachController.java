package com.pers.aiyin.fitness.controller;

import com.pers.aiyin.fitness.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CoachController {

    @Autowired
    private CoachService coachService;


}
