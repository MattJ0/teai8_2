package com.mattjohnson.teai8_2.hateoas.representation_model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
public class NoteModel extends RepresentationModel<NoteModel> {

    private Integer id;

    private String title;

    private String content;

    private Integer userId;


}
