package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class SecondControllerTest {

  @GetMapping("/main")
  @ResponseBody
    public String main() {
      return "<h1> Hello </h1>";
  }


  @GetMapping("/now")
  @ResponseBody
    public String now() {
    String html = "";

    LocalDate today = LocalDate.now();
    int month = today.getMonthValue();
    int day = today.getDayOfMonth();

    html = "오늘은 " + month + "월 " + day + "일 입니다.";

    return html;
  }

  int cnt = 124;
  @GetMapping("/count1")
  @ResponseBody
    public String count1() {
      String html = "";

      cnt ++ ;
      html = Integer.toString(cnt);

      return html;
  }

  @GetMapping("/count2")
  @ResponseBody
    public String count2() {
      String html = "" ;
      cnt++;

      String cntStr = Integer.toString(cnt);

      for (int i = 0 ; i < cntStr.length(); i++ ) {
          html += String.format("<img src= \"/number/number %c.jpg\" width = \"100\" height = \"100\">", cntStr.charAt(i));
      }
      return html;
  }

  @GetMapping("/banner")
  @ResponseBody
    public String banner () {
      String html = "";
      String[] banners = {"naver","daum","google"};

      for (int i = 0 ; i < banners.length; i++) {
          html += String.format(
                  "<a href \"www.%s.net\"><img src = \"/baner/baner %s.jpg\" width = \"300\" height = \"100\"><br>"
                  , banners[i], banners[i]
          );
      }

      return html;
  }
}
