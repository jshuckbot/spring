package ru.db.lesson_3.controllers;

import org.springframework.web.bind.annotation.*;
import ru.db.lesson_3.models.User;
import ru.db.lesson_3.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private RegistrationService service;

    public UserController(RegistrationService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }
    
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }
}