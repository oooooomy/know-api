package com.example.demo.service;

import com.example.demo.model.entity.Article;
import com.example.demo.model.vo.ArticleVo;

import java.util.List;

public interface ArticleService {

    void agree(String id);

    Article save(Article article);

    List<ArticleVo> findAll(String type);

    List<ArticleVo> search(String value);

    ArticleVo findById(String id);

}
