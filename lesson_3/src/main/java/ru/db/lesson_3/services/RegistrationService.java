package ru.db.lesson_3.services;

import org.springframework.stereotype.Service;
import ru.db.lesson_3.models.User;

@Service
public class RegistrationService {
    private DataProcessingService dataProcessingService;
    private UserService userService;  //TODO
    private NotificationService notificationService; //TODO
    

    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public User processRegistration(String name, int age, String email) {
        // Создаем пользователя
        User user = userService.createUser(name, age, email);
        // Добавляем в репо
        dataProcessingService.addUserToList(user);
        // Оповещение в консоль о созданном пользователе
        notificationService.notifyUser(user);
        
        return user;
    }
}