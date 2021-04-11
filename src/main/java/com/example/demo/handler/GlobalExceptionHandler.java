package com.example.demo.handler;

import com.example.demo.annotation.DisableBaseResponse;
import com.example.demo.model.support.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 捕获controller异常
 * controller抛出异常执行下边的函数
 * 返回Response写入ApiResult
 */
@ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    @DisableBaseResponse
    public Object handleException(Exception e) {
        logger.error(e.getMessage());
        return new ResponseResult<>(400, e.getMessage());
    }

}
