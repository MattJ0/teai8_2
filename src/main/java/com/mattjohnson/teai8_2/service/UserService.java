package com.mattjohnson.teai8_2.service;

import com.mattjohnson.teai8_2.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(User user);

    User deleteUser(User user);

    List<User> findAllUsers();

    Optional<User> findUserById();
}
