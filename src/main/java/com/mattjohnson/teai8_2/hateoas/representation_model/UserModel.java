package com.mattjohnson.teai8_2.hateoas.representation_model;

import com.mattjohnson.teai8_2.dto.UserDto;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
public class UserModel extends RepresentationModel<UserModel> {

    private Integer id;

    private String name;

    private String email;


    public UserModel(UserDto userDto) {
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
    }
}
