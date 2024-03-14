package ru.gb.lesson_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson_5.models.Status;
import ru.gb.lesson_5.models.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByStatus(Status status);
    
}