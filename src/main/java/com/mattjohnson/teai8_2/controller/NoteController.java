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
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/userId/{id}")
    public ResponseEntity<CollectionModel<NoteModel>> getNotesByUserId(@PathVariable Integer id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<NoteModel>> getNoteById(@PathVariable Integer id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addNote() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping
//    public ResponseEntity updateNote() {
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//

    @DeleteMapping
    public ResponseEntity deleteNote() {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
