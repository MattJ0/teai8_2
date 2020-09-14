package com.mattjohnson.teai8_2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mattjohnson.teai8_2.entity.Note;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    @JsonIgnore
    private Integer id;

    @NotBlank(message = "Name is mandatory and cannot be blank.")
    @Length(min = 8, max = 25, message = "The required number of characters in the name is 8-25")
    private String name;

    @NotBlank(message = "Email is mandatory and cannot be blank.")
    @Email()
    private String email;

    @JsonIgnore
    private Set<Note> noteSet;


}
