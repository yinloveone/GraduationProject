package com.pers.aiyin.fitness.utils;

public enum  ResponseCode {
    SUCCESS(0,"成功"),

    FAIL(1,"失败");
    private Integer code;

    private String message;
    ResponseCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }
    public Integer code() {
        return this.code;
    }
    public String message() {
        return this.message;
    }
    public static String getMessage(String name) {
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
            return item.message;
            }
        }
        return name;
    }
    public static Integer getCode(String name) {
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
    return null;
    }
    
}
