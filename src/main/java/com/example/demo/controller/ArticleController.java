package com.example.demo.controller;

import com.example.demo.constant.ArticleType;
import com.example.demo.model.entity.Article;
import com.example.demo.model.vo.ArticleVo;
import com.example.demo.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/type/all")
    public String[] findAllType() {
        return ArticleType.list;
    }

    @GetMapping("/agree/{id}")
    public void agree(@PathVariable String id) {
        articleService.agree(id);
    }

    @GetMapping("/search/{value}")
    public List<ArticleVo> search(@PathVariable String value) {
        return articleService.search(value);
    }

    @PostMapping("")
    public Article save(@RequestBody Article article) {
        return articleService.save(article);
    }

    @GetMapping("")
    public List<ArticleVo> findAll(String type) {
        return articleService.findAll(type);
    }

    @GetMapping("/{id}")
    public ArticleVo findById(@PathVariable String id) {
        return articleService.findById(id);
    }

}
