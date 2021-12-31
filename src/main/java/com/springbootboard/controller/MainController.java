package com.springbootboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // 메인페이지 리다이렉트용
    @GetMapping("/")
    public String mainRedirect() {

        return "redirect:/board/list";
    }
}
