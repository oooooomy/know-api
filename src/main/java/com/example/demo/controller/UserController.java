package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.model.vo.UserVo;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("")
    public void save(@RequestBody User user) throws Exception {
        userService.save(user);
    }

    @PostMapping("/login")
    public UserVo login(@RequestBody User user) throws Exception{
        return userService.login(user);
    }

}
