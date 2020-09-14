package com.mattjohnson.teai8_2.service;

import com.mattjohnson.teai8_2.dto.UserDto;
import com.mattjohnson.teai8_2.entity.User;
import com.mattjohnson.teai8_2.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, IModelMapper<User, UserDto> {

    private final UserRepo userRepo;

    private final ModelMapper modelMapper;

    private NoteService noteService;


    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper, NoteService noteService) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.noteService = noteService;
    }

    @Override
    public boolean addUser(UserDto userDto) {
        if (userRepo.existsUserByEmail(userDto.getEmail()) || userRepo.existsUserByName(userDto.getName())) {
            return false;
        }
        userRepo.save(convertToEntity(userDto));
        return true;
    }


    @Transactional
    @Override
    public boolean deleteUser(Integer id) {
        Optional<User> user = userRepo.findByIdAndRemovedIsFalse(id);
        if (user.isPresent()) {
            noteService.deleteAllNotesByUserId(id);
            user.get().setRemoved(true);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepo.findAllByRemovedIsFalse();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findUserById(Integer id) {
        Optional<User> user = userRepo.findByIdAndRemovedIsFalse(id);
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
