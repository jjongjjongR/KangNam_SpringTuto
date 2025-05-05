package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThirdControllerTest {
    @GetMapping("/sum/{number}")
    @ResponseBody
    public String sumpage(@PathVariable int number) {
        String html = "";
        int sumnum = 0 ;
        for(int i = 1; i <= number; i++ )
        {
            sumnum = sumnum + i;
        }

        html = String.format("<h1>0에서 %d까지 합한 값은 %d입니다.</h1>", number, sumnum);

        return html;
    }

    @GetMapping("/user/{username}/orders/{orderNo}")
    @ResponseBody
    public String getOrder(@PathVariable String username, String orderNo){
        return "UserName: " + username + "OrderNo. : " + orderNo ;
    }
}
