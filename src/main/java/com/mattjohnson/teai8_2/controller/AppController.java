package com.mattjohnson.teai8_2.controller;

import com.mattjohnson.teai8_2.service.NoteService;
import com.mattjohnson.teai8_2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AppController {

    private NoteService noteService;

    private UserService userService;


    @GetMapping
    public ResponseEntity<String> get() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }


}
