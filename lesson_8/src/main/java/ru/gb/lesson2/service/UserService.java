package ru.gb.lesson2.service;

import org.springframework.stereotype.Service;
import ru.gb.lesson2.aspects.TrackUserAction;
import ru.gb.lesson2.models.User;
import ru.gb.lesson2.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @TrackUserAction
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
    
    @TrackUserAction
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}