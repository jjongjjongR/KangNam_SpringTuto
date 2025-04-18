package com.example.boardproject.controller;

import com.example.boardproject.dto.ArticleForm;
import com.example.boardproject.entity.Article;
import com.example.boardproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm){
        articleForm.logInfo();

        //1. DTO를 Entity로 변환
        Article article = articleForm.toEntity();
        article.logInfo();

        //2. respository를 통해 DB로 엔터티를 저장
        Article saved = articleRepository.save(article);
        saved.logInfo();

        return "";
    }
}
