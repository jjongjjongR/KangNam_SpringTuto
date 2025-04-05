package com.example.boardproject.dto;

import com.example.boardproject.entity.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Slf4j

public class ArticleForm {

    private String title; //mustache와 동일하게 해야 받을 수 있음.
    private String  content; //mustache와 동일하게 해야 받을 수 있음.

    public Article toEntity(){
        return new Article(title, content);
    }

    public void logInfo() {
        log.info("title:{}, content: {}", title, content);
    }

}
