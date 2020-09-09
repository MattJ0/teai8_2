package com.mattjohnson.teai8_2.hateoas.assembler;

import com.mattjohnson.teai8_2.controller.UserController;
import com.mattjohnson.teai8_2.hateoas.representation_model.UserModel;
import com.mattjohnson.teai8_2.entity.User;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class UserReprModelAssembler extends RepresentationModelAssemblerSupport<User, UserModel> {


    public UserReprModelAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(User user) {
        return createModelWithId(user.getId(), user);
    }


}
