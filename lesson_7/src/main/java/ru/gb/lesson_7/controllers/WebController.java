package ru.gb.lesson_7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    
    @GetMapping("/login")
    public String loginIn() {
        return "login";
    }
    
    @GetMapping("/public-data")
    public String publicPage() {
        return "public_page";
    }
    
    @GetMapping("/private-data")
    public String privatePage() {
        return "private_page";
    }
    
    
}