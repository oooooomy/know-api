package com.example.demo.model.vo;

import lombok.Data;

@Data
public class UserVo {

    private String id;

    private String nickname;

    //image id
    private String avatar;

    private String school;

    private String createAt;

    private Integer articleCount;

    private Integer videoCount;

    private Integer commentCount;

}
