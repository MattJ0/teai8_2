package com.mattjohnson.teai8_2.hateoas.resource;

import com.mattjohnson.teai8_2.model.User;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
public class UserRepresentationModel extends RepresentationModel<UserRepresentationModel> {

    private Integer id;

    private String name;

    private String email;

    public UserRepresentationModel(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
