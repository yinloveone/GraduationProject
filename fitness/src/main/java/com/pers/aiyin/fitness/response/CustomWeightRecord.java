package com.pers.aiyin.fitness.response;

import lombok.Data;

import java.util.Date;

@Data
public class CustomWeightRecord {
    private Integer weiRecordId;

    private Double weight;

    private Date recordTime;

    private Integer stuId;

    private String recordTimeStr;
}
