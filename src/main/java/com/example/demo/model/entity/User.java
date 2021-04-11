package com.example.demo.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("t_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;

    private String nickname;

    private String phone;

    private String password;

    //image id
    private String avatar;

    private String school;

    private String createAt;

}
