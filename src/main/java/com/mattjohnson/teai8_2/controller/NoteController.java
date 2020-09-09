package com.mattjohnson.teai8_2.controller;

import com.mattjohnson.teai8_2.hateoas.assembler.NoteReprModelAssembler;
import com.mattjohnson.teai8_2.hateoas.representation_model.NoteModel;
import com.mattjohnson.teai8_2.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<CollectionModel<NoteModel>> getAllNotes() {
        return
    }

    @GetMapping
    public ResponseEntity<CollectionModel<NoteModel>> getNotesByUserId() {

    }

    @GetMapping
    public ResponseEntity<EntityModel<NoteModel>> getNoteById() {

    }

    @PostMapping
    public ResponseEntity addNote() {

    }

    @PatchMapping
    public ResponseEntity updateNote() {

    }

    @DeleteMapping
    public ResponseEntity deleteNote() {

    }


}
