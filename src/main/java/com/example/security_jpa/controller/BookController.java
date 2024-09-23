package com.example.security_jpa.controller;

import com.example.security_jpa.dao.MemberDAO;
import com.example.security_jpa.entity.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private MemberDAO memberDAO;

    @GetMapping("/listBook")
    public void list(HttpSession session) {
        Authentication authentication
                = SecurityContextHolder.getContext().getAuthentication();

        User user = (User)authentication.getPrincipal();

        String id = user.getUsername();

        Member m = memberDAO.findById(id).get();

        session.setAttribute("loginUSER", m);
    }

}
