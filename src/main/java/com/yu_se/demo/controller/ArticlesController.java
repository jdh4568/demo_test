package com.yu_se.demo.controller;

import com.yu_se.demo.dto.ArticleForm;
import com.yu_se.demo.entity.Article;
import com.yu_se.demo.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

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
        return "redirect:/articles/"+saved.getId();
    }

    @GetMapping("/articles/{id}")   // 1. 어노테이션 작성
    public String show(@PathVariable Long id, Model model){  // 2. show함수 작성
        log.info("id = " +id);  //id 잘 받았는지 확인
        //PathVariable를 이용해서 url로 들어온전달값을 컨트롤러의 매개변수로 가져옴

        // 1. id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. 모델에 데이터 등록
        model.addAttribute("article", articleEntity);

        // 3. 뷰페이지 반환
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        // 1. 모든 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 모델에 데이터 등록
        model.addAttribute("articleList", articleEntityList);
        // 3. 뷰 페이지 설정하기
        return "articles/index";
    }
}
