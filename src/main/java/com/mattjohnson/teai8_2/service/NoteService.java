package com.mattjohnson.teai8_2.service;

import com.mattjohnson.teai8_2.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    Note addNote(Note note);

    boolean editNote(Integer id, Note note);

    Optional<Note> deleteNote(Integer id);

    Optional<Note> findNoteById(Integer id);

    List<Note> findNotesByUserId(Integer id);


}
