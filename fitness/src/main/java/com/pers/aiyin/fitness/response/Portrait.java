package com.pers.aiyin.fitness.response;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Portrait {
    private Integer stuId;
    private Integer coachId;
    private MultipartFile file;
}
