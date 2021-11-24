package com.accounting.services;


import com.accounting.entitites.Note;
import com.accounting.repositories.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public Note createNote(Note note) {
        return repository.save(note);
    }

    public Note findNote(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Iterable<Note> findAllNotes() {
        return repository.findAll();
    }
}