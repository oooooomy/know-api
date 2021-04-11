package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.entity.Article;
import com.example.demo.model.entity.Comment;
import com.example.demo.model.entity.User;
import com.example.demo.model.vo.CommentVo;
import com.example.demo.service.CommentService;
import com.example.demo.utils.DataTimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public CommentVo save(Comment comment) {
        comment.setCreateAt(DataTimeUtil.getNowTimeString());
        commentMapper.insert(comment);
        Article article = articleMapper.selectById(comment.getAid());
        article.setCommentCount(article.getCommentCount() + 1);
        articleMapper.updateById(article);
        User user = userMapper.selectById(comment.getUid());
        user.setPhone("");
        user.setPassword("");
        return new CommentVo(comment, user);
    }

    @Override
    public List<CommentVo> findByArticle(String articleId) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.in("aid", articleId);
        List<Comment> comments = commentMapper.selectList(wrapper);
        List<CommentVo> result = new ArrayList<>();
        for (Comment comment : comments) {
            User user = userMapper.selectById(comment.getUid());
            user.setPhone("");
            user.setPassword("");
            result.add(new CommentVo(comment, user));
        }
        return result;
    }

}
