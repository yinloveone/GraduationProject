package com.pers.aiyin.fitness.controller;
import com.pers.aiyin.fitness.utils.FileHandleUtil;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;



@RestController
public class UploadController {
    @PostMapping(value = "/upload")
    public Result upload(HttpServletRequest request, MultipartFile file){
        try {

            return Result.success(FileHandleUtil.upload(file.getInputStream(), "image/", file.getOriginalFilename()));
        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.failure(ResponseCode.FAIL);
}

}
