package com.example.demo.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("t_image")
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    private String id;

    private byte[] data;

}
