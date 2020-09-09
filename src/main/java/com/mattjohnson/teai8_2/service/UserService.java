package com.mattjohnson.teai8_2.service;

import com.mattjohnson.teai8_2.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean addUser(UserDto userDto);

    boolean deleteUser(Integer id);

    List<UserDto> findAllUsers();

    Optional<UserDto> findUserById(Integer id);

}
