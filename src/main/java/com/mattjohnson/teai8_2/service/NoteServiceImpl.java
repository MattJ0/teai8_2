package com.mattjohnson.teai8_2.service;

import com.mattjohnson.teai8_2.model.Note;
import com.mattjohnson.teai8_2.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepo noteRepo;


    @Autowired
    public NoteServiceImpl(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    @Override
    public Note addNote(Note note) {
        return null;
    }

    @Override
    public boolean editNote(Integer id, Note note) {
        return false;
    }

    @Override
    public Optional<Note> deleteNote(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Note> findNoteById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Note> findNotesByUserId(Integer id) {
        return null;
    }
}
