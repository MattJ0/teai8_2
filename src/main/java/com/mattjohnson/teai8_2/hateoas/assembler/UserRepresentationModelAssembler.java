package com.mattjohnson.teai8_2.hateoas.assembler;

import com.mattjohnson.teai8_2.hateoas.resource.UserRepresentationModel;
import com.mattjohnson.teai8_2.model.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class UserRepresentationModelAssembler implements RepresentationModelAssembler<User, UserRepresentationModel> {

    @Override
    public UserRepresentationModel toModel(User entity) {
        return null;
    }

    @Override
    public CollectionModel<UserRepresentationModel> toCollectionModel(Iterable<? extends User> entities) {
        return null;
    }
}
