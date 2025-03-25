package com.example.templateproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class ExampleController {
    @GetMapping("/varex")
    @ResponseBody
    public String varex(Model model) {
        model.addAttribute("name","John");
        return "varex";
    }

    //object ex
    @GetMapping("/objectex")
    @ResponseBody
    public String person(Model model) {
        Person person = new Person("아이유", 25, "서울특별시");
        model.addAttribute("person",person);
        return "objectex";
    }

    @GetMapping("/conditionex")
    public String login (Model model){
        boolean logedIn = false;
        model.addAttribute("username","아이유");
        model.addAttribute("logedIn",logedIn);

        return "conditionex";
    }

    @GetMapping("/loopex")
    public String getPersionList(Model model){
        String[] fruits = {"apple", "banana", "orange"};

        List<Person> persons = Arrays.asList(
                new Person("아이유", 25, "서울"),
                new Person("유재석", 50, "부산"),
                new Person("안세영", 20, "광주")
        );

        model.addAttribute("fruits", fruits);
        model.addAttribute("persons",persons);

        return "loopex";
    }
}
