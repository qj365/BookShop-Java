package com.mta.bookshopadmin.controller;

import com.mta.bookshop.entity.User;
import com.mta.bookshopadmin.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/Login", "/login"})
    public String Login(){
        return "login/login";
    }

    @GetMapping("/Register")
    public String Register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login/signup";
    }

    @PostMapping("/Register/Processer")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "redirect:/Login";
    }

}
