package com.mattjohnson.teai8_2.hateoas.representation_model;

import com.mattjohnson.teai8_2.dto.NoteDto;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
public class NoteModel extends RepresentationModel<NoteModel> {

    private Integer id;

    private String title;

    private String content;

    private Integer userId;


    public NoteModel(NoteDto noteDto) {
        this.id = noteDto.getId();
        this.title = noteDto.getTitle();
        this.content = noteDto.getContent();
        this.userId = noteDto.getUserId();
    }
}
