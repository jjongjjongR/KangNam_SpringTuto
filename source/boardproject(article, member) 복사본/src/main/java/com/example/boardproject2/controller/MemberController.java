package com.example.boardproject2.controller;


import com.example.boardproject2.dto.MemberForm;
import com.example.boardproject2.entity.Article;
import com.example.boardproject2.entity.Member;
import com.example.boardproject2.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class MemberController {

    //Dipendency Injection
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //signup
    @GetMapping("/signup")
    public String signup() {return "members/new";}

    //회원 등록
    @PostMapping("/join")
    public String join(MemberForm memberForm) {

        //dto -> entity
        Member member = memberForm.toMember();

        Member saved = memberRepository.save(member);

        //member 상세 페이지로 redirect
        return "redirect:/members/" + saved.getId();
    }

    //상세 멤버 조회
    @GetMapping("/members/{id}")
    public String show(@PathVariable("id")Long id, Model model) {

        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", member);

        return "members/show";
    }

    //member list 조회
    @GetMapping("/members")
    public String list(Model model) {

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);

        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable("id")Long id, Model model) {
        Member memberEntity = memberRepository.findById(id).orElse(null);
        model.addAttribute("member",memberEntity);

        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm memberForm){

        Member member = memberForm.toMember();
        Member target = memberRepository.findById(member.getId()).orElse(null);
        if(target != null) {
            memberRepository.save(member);
        }
        return "redirect:/members/" + target.getId();
    }

}
