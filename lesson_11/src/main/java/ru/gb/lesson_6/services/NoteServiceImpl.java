package ru.gb.lesson_6.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.lesson_6.models.Note;
import ru.gb.lesson_6.repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Note updateNote(Note note, Long id) {
        Note noteById = getNoteById(id);
        noteById.setTitle(note.getTitle());
        noteById.setDescription(note.getDescription());
        
        return noteRepository.save(noteById);
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        Note noteById = getNoteById(id);
        noteRepository.delete(noteById);
    }
}