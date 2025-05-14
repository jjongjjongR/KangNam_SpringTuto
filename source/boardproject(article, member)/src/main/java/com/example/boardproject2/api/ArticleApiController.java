package com.example.boardproject2.api;

import com.example.boardproject2.dto.ArticleForm;
import com.example.boardproject2.entity.Article;
import com.example.boardproject2.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/articles")
public class ArticleApiController {

//  @Autowired
//  private ArticleRepository articleRepository;
    private final ArticleRepository articleRepository;
    //이거 쳐주고 control + enter
    public ArticleApiController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    //article 리스트를 json으로 보내기
    @GetMapping("/articles")
    public List<Article> list() {
//        List<Article> articles = articleRepository.findAll();
//        return articles;
        return articleRepository.findAll();
    }

    //하나의 article을 json으로 보내기
    @GetMapping("{id}")
    public Article read(@PathVariable("id") Long id) {
//        Article article = articleRepository.findById(id).orElse(null);
//        return article;
        return articleRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Article create(@RequestBody ArticleForm articleForm){
        log.info("ArticleForm: {}", articleForm);

        Article article = articleForm.toEntity();
        log.info("Article: {}", article);

        Article saved = articleRepository.save(article);

        return saved;
    }

    @PatchMapping("{id}")
    public ResponseEntity<Article> update(@PathVariable("id") Long id,
                                          @RequestBody ArticleForm articleForm) {
        // 1. DTO -> Entity 변환
        Article article = articleForm.toEntity(); //article: 수정할 데이터
        // 2. target 조회하기 //target: 기존 데이터
        Article target = articleRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리
        if(target == null || id != article.getId()) {
            log.info("잘못된 요청!: id = {}, article: {}", id, article);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 4. 업데이트 및 정상응답(200)
        target.patch(article);
        Article updated = articleRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Article> delete(@PathVariable("id") Long id) {
        // 1. 대상찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리하기
        if(target == null) return ResponseEntity.badRequest().build();
        // 3. 대상 삭제하기
        articleRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
