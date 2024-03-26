package ru.gb.lesson_6.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.lesson_6.models.Note;
import ru.gb.lesson_6.repository.NoteRepository;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class NoteServiceImplIntegrationTest {
    @MockBean
    private NoteRepository noteRepository;
    @Autowired
    private NoteService noteService;

    @Test
    @DisplayName("createNote")
    public void createNote() {
        // Предпосылка

        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Note 1");
        note1.setDescription("Description note 1");

        given(noteRepository.findById(1L)).willReturn(Optional.of(note1));
        // Вызов
        noteService.createNote(note1);
        // Проверка
        System.out.println(noteRepository.findById(note1.getId()));
        assertEquals(noteService.getNoteById(note1.getId()).getDescription(), "Description note 1");
    }
}