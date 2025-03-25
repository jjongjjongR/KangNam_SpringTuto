package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class SecondController {
    @GetMapping("/main")
    @ResponseBody
    public String main() {
        return "<h1>Hello!</h1>";
    }

    @GetMapping("/now")
    @ResponseBody
    public String now() {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        /*
        교수님 답 String html = "";
        html = "오늘은 " + month + "월 " + day +"일 입니다.";
        retrun html;
        */
        return "오늘은 " + month +"월 " + day + "일 입니다.";
    }
    @GetMapping("/now2")
    @ResponseBody
    public String now2() {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        /* 교수님 답 String html = "";
        html = "오늘은 " + month + "월 " + day +"일 입니다.";
        html = String.format("<h1>%s</h1>", html);
        retrun html;
        */
        return "<h1>오늘은 "+month+"월 "+day+"일 입니다.</h1>";
    }

    int cnt = 12; //전역변수로

    @GetMapping("/count")
    @ResponseBody
    public String count() {
        String html = "";
        cnt++;

        html = Integer.toString(cnt);

        return html;
    }

    @GetMapping("/count2")
    @ResponseBody
    public String count2() {
        String html = "";
        cnt++;

        String cntStr = Integer.toString(cnt);

        for(int i =0 ; i<cntStr.length();i++){
            html += String.format( "<img src=\"/number/number %c.png\" width=\"100\" height=\"100\">", cntStr.charAt(i));
        }

        return html;
    }

    @GetMapping("/banner")
    @ResponseBody
    public String banner() {
        String html = "";
        html = "<a href = \"https://www.naver.com\"><img src = \"/banner/naver.jpeg\" width=\"200\" height=\"100\"> </a>" +
                "<a href = \"https://www.daum.net\"><img src = \"/banner/daum.jpeg\" width=\"200\" height=\"100\"> </a>" +
                "<a href = \"https://www.google.com\"><img src = \"/banner/google.jpeg\" width=\"200\" height=\"100\"> </a>";

        return html;

        /*
        교수님 정답
        String[] banner = {"daum", "google", "naver"};
        for(int i = 0 ; i < banner.length; i++) {
            html += String.format(
                "<a href=\"https://www.%s.net\"><img src=\"banner/%s.jpg\" width =\"200\" height=\"100\"></a><br>"
                , banners[i], banners[i]);
        }
         */
    }

}