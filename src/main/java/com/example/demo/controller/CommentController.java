package com.example.demo.controller;

import com.example.demo.model.entity.Comment;
import com.example.demo.model.vo.CommentVo;
import com.example.demo.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("")
    public CommentVo save(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @GetMapping("/article/{id}")
    public List<CommentVo> findByArticle(@PathVariable String id) {
        return commentService.findByArticle(id);
    }

}
