package com.accounting.controllers;

import com.accounting.entitites.Note;
import com.accounting.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note created = noteService.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        Note note = noteService.findNote(id);
        return ResponseEntity.ok(note);
    }

    @GetMapping
    public ResponseEntity<Iterable<Note>> getAllNotes() {
        Iterable<Note> notes = noteService.findAllNotes();
        return ResponseEntity.ok(notes);
    }
}