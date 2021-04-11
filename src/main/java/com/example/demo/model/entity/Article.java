package com.example.demo.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("t_article")
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private String id;

    private String uid;

    private String title;

    //是否有封面图片
    private boolean hasPoster;

    //类型
    private String type;

    //封面图片id
    private String poster;

    //内容
    private String content;

    //点赞数
    private Integer agreeCount;

    //评论数
    private Integer commentCount;

    private String createAt;

}
