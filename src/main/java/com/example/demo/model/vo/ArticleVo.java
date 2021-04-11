package com.example.demo.model.vo;

import com.example.demo.model.entity.Article;
import com.example.demo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVo {

    private Article article;

    private User author;

}
