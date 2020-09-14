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


    //TODO
    @Override
    public boolean updateNote(NoteDto noteDto) {
        Optional<Note> note = noteRepo.findById(noteDto.getId());
        if (note.isPresent()) {
            if (note.get().getUser().getId().equals(noteDto.getUserId())) {
                Note update = note.get();
                update.setTitle(noteDto.getTitle());
                update.setContent(noteDto.getContent());
                update.setModificationDate(ZonedDateTime.now());
                noteRepo.save(update);
                return true;
            }
            return false;
        }
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


    @Override
    public Optional<NoteDto> findNoteById(Integer id) {
        Optional<Note> note = noteRepo.findByIdAndRemoved(id, false);
        return note.map(this::convertToDto);
    }

    @Override
    public List<NoteDto> findNotesByUserId(Integer id) {
        List<Note> notes = noteRepo.findAllByUserIdAndRemoved(id, false);
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
