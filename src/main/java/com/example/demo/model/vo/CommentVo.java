package com.example.demo.model.vo;

import com.example.demo.model.entity.Comment;
import com.example.demo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {

    private Comment comment;

    private User user;

}
