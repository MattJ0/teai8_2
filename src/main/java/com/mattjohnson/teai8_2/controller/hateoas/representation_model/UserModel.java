package com.mattjohnson.teai8_2.controller.hateoas.representation_model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
public class UserModel extends RepresentationModel<UserModel> {

    private Integer id;

    private String name;

    private String email;


}
