package com.example.demo.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("t_comment")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String id;

    //用户id
    private String uid;

    //文章id
    private String aid;

    private String content;

    private String createAt;

}
