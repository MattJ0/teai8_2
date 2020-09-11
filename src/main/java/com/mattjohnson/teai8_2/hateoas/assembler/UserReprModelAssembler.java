package com.mattjohnson.teai8_2.hateoas.assembler;

import com.mattjohnson.teai8_2.controller.UserController;
import com.mattjohnson.teai8_2.dto.UserDto;
import com.mattjohnson.teai8_2.hateoas.representation_model.UserModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserReprModelAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {


    public UserReprModelAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto userDto) {

        UserModel userModel = instantiateModel(userDto);

        userModel.add(linkTo(
                methodOn(UserController.class)
                        .getUserById(userDto.getId()))
                .withSelfRel());

        userModel = createModelWithId(userDto.getId(), userDto);
        userModel.setId(userDto.getId());
        userModel.setEmail(userDto.getEmail());
        userModel.setName(userDto.getName());
        return userModel;
    }

    @Override
    public CollectionModel<UserModel> toCollectionModel(Iterable<? extends UserDto> userDtos) {
        CollectionModel<UserModel> userModels = super.toCollectionModel(userDtos);

        userModels.add(linkTo(methodOn(UserController.class).getUsers()).withSelfRel());

        return userModels;
    }


}
