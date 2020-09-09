package com.mattjohnson.teai8_2.service;

import com.mattjohnson.teai8_2.dto.NoteDto;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    boolean addNote(NoteDto noteDto);

    boolean editNote(NoteDto noteDto);

    boolean deleteNote(Integer id);

    Optional<NoteDto> findNoteById(Integer id);

    List<NoteDto> findNotesByUserId(Integer id);


}
