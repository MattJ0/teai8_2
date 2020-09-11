package com.mattjohnson.teai8_2.hateoas.representation_model;

import com.mattjohnson.teai8_2.dto.NoteDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserModel extends RepresentationModel<UserModel> {

    private Integer id;

    private String name;

    private String email;

    private Set<NoteDto> notes;


//    public UserModel(UserDto userDto) {
//        this.id = userDto.getId();
//        this.name = userDto.getName();
//        this.email = userDto.getEmail();
//    }
}
