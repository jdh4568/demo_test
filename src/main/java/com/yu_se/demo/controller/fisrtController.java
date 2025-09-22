package com.yu_se.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class fisrtController {
    @GetMapping("/hi")
    public String niceTOMeetYou(Model model){   // 모델 객체 가져오기
        model.addAttribute("username", "길동");   // 모델에 사용할 변수 등록
        return "greetings"; //파일 이름만 적어서 반환

    }
    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "홍길동");
        return "bye";
    }
}
