package com.mattjohnson.teai8_2.service;

import com.mattjohnson.teai8_2.dto.UserDto;
import com.mattjohnson.teai8_2.entity.Note;
import com.mattjohnson.teai8_2.entity.User;
import com.mattjohnson.teai8_2.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, IModelMapper<User, UserDto> {

    private final UserRepo userRepo;

    private final ModelMapper modelMapper;


    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addUser(UserDto userDto) {
        if (userRepo.existsUserByEmail(userDto.getEmail()) || userRepo.existsUserByName(userDto.getName())) {
            return false;
        }
        userRepo.save(convertToEntity(userDto));
        return true;
    }


    @Override
    public boolean deleteUser(Integer id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findUserById(Integer id) {
        Optional<User> user = userRepo.findById(id);
        return user.map(this::convertToDto);
    }

    @Override
    public UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);

    }

    @Override
    public User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);

    }
}
