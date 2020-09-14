package com.mattjohnson.teai8_2.controller;

import com.mattjohnson.teai8_2.controller.hateoas.assembler.UserReprModelAssembler;
import com.mattjohnson.teai8_2.controller.hateoas.representation_model.UserModel;
import com.mattjohnson.teai8_2.dto.UserDto;
import com.mattjohnson.teai8_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        List<UserDto> userDtoList = userService.findAllUsers();
        return new ResponseEntity<>(userReprModelAssembler.toCollectionModel(userDtoList), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@Validated @PathVariable Integer id) {
        Optional<UserDto> userDto = userService.findUserById(id);
        return userDto.map(dto -> new ResponseEntity<>(userReprModelAssembler.toModel(dto), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity addUser(@Validated @RequestBody UserDto userDto) {
        boolean add = userService.addUser(userDto);
        if (add) {
            return new ResponseEntity<>("User was added", HttpStatus.CREATED);
        } else return new ResponseEntity<>("The given name or email address is already taken", HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@Validated @PathVariable Integer id) {
        boolean delete = userService.deleteUser(id);
        if (delete) {
            return new ResponseEntity<>("User was deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("user with this id does not exist", HttpStatus.NOT_FOUND);
    }

//    @GetMapping
//    public ResponseEntity<CollectionModel<UserModel>> getUserWithNotes() {
//
//    }
}
