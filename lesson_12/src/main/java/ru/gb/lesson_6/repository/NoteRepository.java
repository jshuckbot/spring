package ru.gb.lesson_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson_6.models.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    
}