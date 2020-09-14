package com.mattjohnson.teai8_2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class NoteDto {

    private Integer id;

    @NotBlank(message = "Title cannot be blank.")
    @Length(min = 1, max = 255, message = "The required number of characters in the title is 1-255")
    private String title;

    private String content;

    private Integer userId;

}
