package com.mattjohnson.teai8_2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mattjohnson.teai8_2.entity.Note;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class UserDto {

    // w DTO odbicie encji (w zakresie udostęþnianych danych), mapowanie w serwisie
    // Output - z serwisu do controllera trafia DTO i jest przerabiane przez assembler zasobów
    // Input - z controllera do serwisu jest przekazywane DTO, serwis mapuje na encję i przekazuje do repo

    //dodać logger @Slf4j

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
