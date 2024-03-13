package ru.gb.lesson_4.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.lesson_4.models.Cat;
import ru.gb.lesson_4.services.CatService;


@Controller
@RequestMapping("/cats")
@AllArgsConstructor
public class CatController {
    
    private final CatService catService;

    @GetMapping
    public String getCats(Model model) {
        model.addAttribute("cats", catService.getAll());
        
        return "cats";
    }
    
    @PostMapping
    public String addCat(Model model, Cat cat) {
        catService.addCatToList(cat);
        model.addAttribute("cats", catService.getAll());
        
        return "cats";
    }
}