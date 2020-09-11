package com.mattjohnson.teai8_2.service;

import com.mattjohnson.teai8_2.dto.NoteDto;
import com.mattjohnson.teai8_2.entity.Note;
import com.mattjohnson.teai8_2.repository.NoteRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class NoteServiceImpl implements NoteService, IModelMapper<Note, NoteDto> {

    private final NoteRepo noteRepo;

    private final ModelMapper modelMapper;

    private final UserService userService;


    @Autowired
    public NoteServiceImpl(NoteRepo noteRepo, ModelMapper modelMapper, @Lazy UserService userService) {
        this.noteRepo = noteRepo;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public boolean addNote(NoteDto noteDto) {
        if (userService.findUserById(noteDto.getUserId()).isPresent()) {
            noteRepo.save(convertToEntity(noteDto));
            return true;
        }
        return false;
    }

    //TODO edycja Note
    @Override
    public boolean updateNote(NoteDto noteDto) {
        return false;
    }

    @Override
    public boolean deleteNote(Integer id) {
        Optional<Note> optionalNote = noteRepo.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setRemoved(true);
            note.setRemovalDate(ZonedDateTime.now());
            noteRepo.save(note);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAllNotesByUserId(Integer id) {
        List<Note> noteList = noteRepo.findAllByUserId(id);
        if (noteList.isEmpty()) {
            return false;
        }
        noteList.forEach(note -> deleteNote(note.getId()));
        return true;
    }

    //TODO mechanizm filtrowania po polu isRemoved w metodach find

    @Override
    public Optional<NoteDto> findNoteById(Integer id) {
        Optional<Note> note = noteRepo.findById(id);
        return note.map(this::convertToDto);
    }

    @Override
    public List<NoteDto> findNotesByUserId(Integer id) {
        List<Note> notes = noteRepo.findAllByUserId(id);
        return notes.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public NoteDto convertToDto(Note note) {
        return modelMapper.map(note, NoteDto.class);
    }

    @Override
    public Note convertToEntity(NoteDto noteDto) {
        return modelMapper.map(noteDto, Note.class);
    }
}
