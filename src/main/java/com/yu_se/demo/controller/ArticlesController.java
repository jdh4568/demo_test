package com.yu_se.demo.controller;

import com.yu_se.demo.dto.ArticleForm;
import com.yu_se.demo.entity.Article;
import com.yu_se.demo.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticlesController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticle(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){  // 폼 데이터를 DTO로 받기
        log.info(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(form.toString());
        // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(form.toString());
        return "";
    }
}
