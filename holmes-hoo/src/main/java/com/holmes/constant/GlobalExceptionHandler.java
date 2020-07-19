package com.holmes.constant;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 全局捕获异常
 * @Author keke
 * @Date 2020/6/21  19:05
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnprocessableException.class)
    @ResponseBody
    public RestResult error(UnprocessableException e) {
        e.printStackTrace();
        return new RestResult(e.getCode(),e.getMessage());
    }
}
