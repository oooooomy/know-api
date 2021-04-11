package com.example.demo.interceptor;

import com.example.demo.mapper.UserMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("Token");
        if (token == null) {
            response.setStatus(403);
            return false;
        }
        if (userMapper.selectById(request.getHeader("Token")) == null) {
            response.setStatus(403);
            return false;
        }
        return true;
    }

}
