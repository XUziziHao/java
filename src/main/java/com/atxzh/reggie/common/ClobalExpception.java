package com.atxzh.reggie.common;

import com.sun.deploy.net.DownloadException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器
 */

@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class ClobalExpception {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    private R<String> exception(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());

        if (ex.getMessage().contains("Duplicate entry")){
            String[] s = ex.getMessage().split(" ");
            String mag = s[2] + "已存在";
            return R.error(mag);
        }
        return R.error("未知错误");
    }

    @ExceptionHandler(CustomException.class)
    private R<String> exception(CustomException ex){
        log.error(ex.getMessage());

        return R.error(ex.getMessage());
    }
}
