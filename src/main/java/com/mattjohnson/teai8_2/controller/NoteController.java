package com.mattjohnson.teai8_2.controller;

import com.mattjohnson.teai8_2.controller.hateoas.assembler.NoteReprModelAssembler;
import com.mattjohnson.teai8_2.controller.hateoas.representation_model.NoteModel;
import com.mattjohnson.teai8_2.dto.NoteDto;
import com.mattjohnson.teai8_2.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/notes")
public class NoteController {

    private NoteService noteService;

    private NoteReprModelAssembler noteReprModelAssembler;

    @Autowired
    public NoteController(NoteService noteService, NoteReprModelAssembler noteReprModelAssembler) {
        this.noteService = noteService;
        this.noteReprModelAssembler = noteReprModelAssembler;
    }

//    @GetMapping
//    public ResponseEntity<String> get() {
//        return new ResponseEntity<>("Hello", HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<CollectionModel<NoteModel>> getAllNotes() {
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/userId/{id}")
    public ResponseEntity<CollectionModel<NoteModel>> getNotesByUserId(@PathVariable Integer id) {
        List<NoteDto> noteDtoList = noteService.findNotesByUserId(id);
        CollectionModel<NoteModel> noteDtoCollectionModel = noteReprModelAssembler.toCollectionModel(noteDtoList);
        if (noteDtoCollectionModel.hasLinks()) {
            return new ResponseEntity<>(noteDtoCollectionModel, HttpStatus.OK);
        } else return new ResponseEntity("User with id:" + id + " not exists", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteModel> getNoteById(@PathVariable Integer id) {
        Optional<NoteDto> noteDto = noteService.findNoteById(id);
        return noteDto.map(dto -> new ResponseEntity<>(noteReprModelAssembler.toModel(dto), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity addNote(@Validated @RequestBody NoteDto noteDto) {
        boolean add = noteService.addNote(noteDto);
        if (add) {
            return new ResponseEntity<>("Note was added", HttpStatus.OK);
        } else return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateNote(@PathVariable Integer id, @Validated @RequestBody NoteDto noteDto) {
        boolean update = noteService.updateNote(noteDto, id);
        if (update) {
            return new ResponseEntity<>("Note was updated", HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteNote(@PathVariable Integer id) {
        boolean delete = noteService.deleteNote(id);
        if (delete) {
            return new ResponseEntity<>("Note was deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Note not found", HttpStatus.NOT_FOUND);
    }


}
