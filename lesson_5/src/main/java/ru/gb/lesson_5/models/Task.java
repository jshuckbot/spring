package ru.gb.lesson_5.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    
    @Enumerated
    private Status status;
    private LocalDateTime created = LocalDateTime.now();
}