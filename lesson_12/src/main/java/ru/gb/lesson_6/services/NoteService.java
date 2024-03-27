package ru.gb.lesson_6.services;

import ru.gb.lesson_6.models.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note updateNote(Note note, Long id);
    Note createNote(Note note);
    void deleteNote(Long id);
}