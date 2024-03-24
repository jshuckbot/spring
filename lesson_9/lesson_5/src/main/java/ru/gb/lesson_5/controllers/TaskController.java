package ru.gb.lesson_5.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson_5.models.Status;
import ru.gb.lesson_5.models.Task;
import ru.gb.lesson_5.services.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;
    
    @GetMapping()
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    
    @PostMapping()
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }
    
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus (@PathVariable Status status) {
        return taskService.getTasksByStatus(status);
    }
    
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id) {
        Task task = taskService.findById(id);
        if (task != null) {
            int currentStatus = task.getStatus().ordinal();
            if (task.getStatus() != Status.COMPLETED) {
                task.setStatus(Status.values()[++currentStatus]);
            }
        }
        return taskService.updateTask(task);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    
}