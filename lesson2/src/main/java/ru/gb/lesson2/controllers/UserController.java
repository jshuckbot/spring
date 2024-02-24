package ru.gb.lesson2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.lesson2.models.User;
import ru.gb.lesson2.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }
    
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }
    
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    
    @GetMapping("user-delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}