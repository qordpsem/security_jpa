package com.example.security_jpa.controller;

import com.example.security_jpa.dao.MemberDAO;
import com.example.security_jpa.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/join")
    public void join(){

    }

    @PostMapping("/join")
    public String join(Member member) {
        member.setPwd(passwordEncoder.encode(member.getPwd()));
        member.setRole("user");
        memberDAO.save(member);
        return "redirect:/login";
    }
}