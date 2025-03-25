package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThirdController {


    @GetMapping("/sum/{number}")
    @ResponseBody
    public String sum(@PathVariable /*오류시 ("number")*/ int number) {
        String html = "";
        int sumnum = 0;
        for(int i = 1 ; number >= i ; i++){
            sumnum = sumnum+i;
        }
        //1에서 10까지의 합 구하기

        html = String.format("<h1>1에서 %d까지의 합은 %d입니다.</h1>", number, sumnum);

        return html;
    }

    @GetMapping("/user/{username}/orders/{orderNo}")
    @ResponseBody
    public String getOrder(@PathVariable String username, @PathVariable int orderNo){
        return "User Name: " + username + ", Order No: " + orderNo;
    }

    @GetMapping("/posts/{category}/{postId}")
    @ResponseBody
    public String getPostDetails(@PathVariable String category, @PathVariable int postId){
        return "Category: " + category + ", Post Id: " + postId;
    }
}
