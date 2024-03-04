package ru.db.lesson_3.services;

import org.springframework.stereotype.Service;
import ru.db.lesson_3.models.User;
import ru.db.lesson_3.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    private UserRepository repository;

    public DataProcessingService(UserRepository repository) {
        this.repository = repository;
    }

    public UserRepository getRepository() {
        return repository;
    }
    
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
    }
    
    public List<User> filtertUsersByAge(List<User> users, int age) {
        return users.stream().filter(user -> user.getAge() > age).collect(Collectors.toList());
    }
    
    public double calculateAverageAge(List<User> users) {
        return users.stream().mapToInt(User::getAge).average().orElse(0);
    }
    
    public void addUserToList(User user) {
        repository.getUsers().add(user);
    }
}