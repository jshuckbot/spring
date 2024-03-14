package ru.gb.lesson_5.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.lesson_5.models.Status;
import ru.gb.lesson_5.models.Task;
import ru.gb.lesson_5.repository.TaskRepository;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }
    
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
    
    public List<Task> getTasksByStatus(Status status) {
        return taskRepository.findByStatus(status);
    }
    
    public void deleteTask(Long id) {
        taskRepository.deleteAllById(Collections.singleton(id));
    }
}