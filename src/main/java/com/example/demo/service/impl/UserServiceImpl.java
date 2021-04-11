package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.VideoMapper;
import com.example.demo.model.entity.Article;
import com.example.demo.model.entity.Comment;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.Video;
import com.example.demo.model.vo.UserVo;
import com.example.demo.service.UserService;
import com.example.demo.utils.DataTimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private VideoMapper videoMapper;

    @Override
    public void save(User user) throws Exception {
        if (userMapper.selectOne(new QueryWrapper<User>().in("phone", user.getPhone())) != null)
            throw new Exception("当前手机号码已注册");
        if (userMapper.selectOne(new QueryWrapper<User>().in("nickname", user.getNickname())) != null)
            throw new Exception("该昵称已存在");
        user.setCreateAt(DataTimeUtil.getNowTimeString());
        userMapper.insert(user);
    }

    @Override
    public UserVo login(User user) throws Exception {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("phone", user.getPhone());
        wrapper.in("password", user.getPassword());
        User one = userMapper.selectOne(wrapper);
        if (one == null) throw new Exception("账号密码错误");
        UserVo userVo = new UserVo();
        userVo.setId(one.getId());
        userVo.setNickname(one.getNickname());
        userVo.setAvatar(one.getAvatar());
        userVo.setSchool(one.getSchool());
        userVo.setCreateAt(one.getCreateAt());
        userVo.setArticleCount(articleMapper.selectCount(new QueryWrapper<Article>().in("uid", one.getId())));
        userVo.setVideoCount(videoMapper.selectCount(new QueryWrapper<Video>().in("uid", one.getId())));
        userVo.setCommentCount(commentMapper.selectCount(new QueryWrapper<Comment>().in("uid", one.getId())));
        return userVo;
    }
}
