package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.entity.Article;
import com.example.demo.model.entity.User;
import com.example.demo.model.vo.ArticleVo;
import com.example.demo.service.ArticleService;
import com.example.demo.utils.DataTimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public void agree(String id) {
        Article article = articleMapper.selectById(id);
        article.setAgreeCount(article.getAgreeCount() + 1);
        articleMapper.updateById(article);
    }

    @Override
    public Article save(Article article) {
        article.setAgreeCount(0);
        article.setCommentCount(0);
        article.setCreateAt(DataTimeUtil.getNowTimeString());
        article.setId(UUID.randomUUID().toString());
        articleMapper.insert(article);
        return article;
    }

    @Override
    public List<ArticleVo> findAll(String type) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        if (!type.equals("all")) {
            wrapper.in("type", type);
        }
        return assembly(wrapper);
    }

    @Override
    public List<ArticleVo> search(String value) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.like("content", value).or().like("title", value);
        return assembly(wrapper);
    }

    @Override
    public ArticleVo findById(String id) {
        Article article = articleMapper.selectById(id);
        User user = userMapper.selectById(article.getUid());
        user.setPassword("");
        user.setPhone("");
        return new ArticleVo(article, user);
    }

    private List<ArticleVo> assembly(QueryWrapper<Article> wrapper) {
        List<Article> articles = articleMapper.selectList(wrapper);
        List<ArticleVo> result = new ArrayList<>();
        for (Article article : articles) {
            User user = userMapper.selectById(article.getUid());
            user.setPassword("");
            user.setPhone("");
            result.add(new ArticleVo(article, user));
        }
        return result;
    }

}
