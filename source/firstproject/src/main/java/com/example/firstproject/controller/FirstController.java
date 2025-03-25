package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller     //Controller 생성
public class FirstController {

    @GetMapping("/hi")      //매핑
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "홍팍");   //getter, setter이 필요가 없음.
        return "greetings";     //greetings 라는 이름을 가진 뷰를 리턴
    }

    @GetMapping("/bye")
    public  String goodBye(Model model){ //GetMapping이 알아서 해주기 때문에 goodBye는 뭘 해도 의미 없음.
        model.addAttribute("username", "조정석");
        return "goodbye";
    }
}
