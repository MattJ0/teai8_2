package com.mattjohnson.teai8_2.controller;

import com.mattjohnson.teai8_2.hateoas.assembler.UserReprModelAssembler;
import com.mattjohnson.teai8_2.hateoas.representation_model.UserModel;
import com.mattjohnson.teai8_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private UserService userService;

    private UserReprModelAssembler userReprModelAssembler;

    @Autowired
    public UserController(UserService userService, UserReprModelAssembler userReprModelAssembler) {
        this.userService = userService;
        this.userReprModelAssembler = userReprModelAssembler;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<UserModel>> getUsers() {

    }

    @GetMapping
    public ResponseEntity<EntityModel<UserModel>> getUserByName() {

    }


    @PostMapping
    public ResponseEntity addUser() {

    }

    @DeleteMapping
    public ResponseEntity deleteUser() {

    }

//    @GetMapping
//    public ResponseEntity<CollectionModel<UserModel>> getUsersWithNotes() {
//
//    }
}
