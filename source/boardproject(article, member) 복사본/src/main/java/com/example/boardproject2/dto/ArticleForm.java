package com.example.boardproject2.dto;

import com.example.boardproject2.entity.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Slf4j
public class ArticleForm {

    //수정을 위한 field

    private Long id;
    private String title;
    private String content;

    public Article toEntity(){

        return new Article(id, title, content);
    }

    public void logInfo() {
        log.info("title: {}, content: {}", title, content);
    }
}
