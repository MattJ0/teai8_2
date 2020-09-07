package com.mattjohnson.teai8_2.hateoas.resource;

import com.mattjohnson.teai8_2.model.Note;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.time.ZonedDateTime;

@Getter
public class NoteRepresentationModel extends RepresentationModel<NoteRepresentationModel> {

    private String title;

    private String content;

    private ZonedDateTime creationDate;

    public NoteRepresentationModel(Note note) {
        this.title = note.getTitle();
        this.content = note.getContent();
        this.creationDate = note.getCreationDate();
    }


}
