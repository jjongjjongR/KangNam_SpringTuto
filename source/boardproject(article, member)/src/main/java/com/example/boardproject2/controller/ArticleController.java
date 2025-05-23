package com.example.boardproject2.controller;


import com.example.boardproject2.dto.ArticleForm;
import com.example.boardproject2.entity.Article;
import com.example.boardproject2.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    //게시글 목록 보기
    @GetMapping("/articles")
    public String list(Model model){

        List<Article> articles = articleRepository.findAll();

        model.addAttribute("articles", articles);

        return "articles/index";
    }

    //게시글 작성 폼
    @GetMapping("/articles/new")
    public String newArticleForm() { return "articles/new"; }


    //게시글 저장
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm, Model model) {
        log.info("{}", articleForm);

        Article article = articleForm.toEntity();

        Article saved = articleRepository.save(article);

        //리스트 페이지로 redirect
        return "redirect:/articles/"+ saved.getId();
    }

    //단일 데이터 조회 (상세보기)
    @GetMapping("/articles/{id}")
    public String show(@PathVariable("id")Long id, Model model) {

        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);

        return "articles/show";
    }

    //데이터 수정을 위해 원본 데이터 가져오기
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable("id")Long id, Model model) {

        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article",articleEntity);

        return "articles/edit";
    }
    
    //수정된 데이터 DB에 저장
    @PostMapping("/articles/update")
    public String update(ArticleForm articleForm){

        log.info("{}", articleForm);

        //DTO를 Entity로 변환하기
        Article article = articleForm.toEntity();
        log.info(article.toString());

        //Entity를 DB에 저장
        //1. DB에서 기존 데이터 가져오기
        Article target = articleRepository.findById(article.getId()).orElse(null);

        //2. 기존 데이터 값 갱신
        if(target != null) {
            articleRepository.save(article);
        }


        //수정 결과 페이지로 redirect
        return "redirect:/articles/"+target.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable("id")Long id, RedirectAttributes rttr) {

        //해당 id에 맞는 article이 좋재하는지 확인
        Article target = articleRepository.findById(id).orElse(null);

        //존재한다면, repository를 통해서 delete작업
        if (target != null){
            articleRepository.deleteById(id);
            rttr.addFlashAttribute("msg", "삭제되었습니다.");
        }

        //리스트페이지로 redirect
        return "redirect:/articles";
    }
}