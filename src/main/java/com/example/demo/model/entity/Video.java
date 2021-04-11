package com.example.demo.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("t_video")
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    private String id;

    private String uid;

    private String type;

    //文件id
    private String fid;

    //标题
    private String title;

    private String createAt;

}
