package com.example.demo.service;

import com.example.demo.model.entity.Comment;
import com.example.demo.model.vo.CommentVo;

import java.util.List;

public interface CommentService {

    CommentVo save(Comment comment);

    List<CommentVo> findByArticle(String articleId);

}
