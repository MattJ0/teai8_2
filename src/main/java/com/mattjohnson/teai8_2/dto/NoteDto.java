package com.mattjohnson.teai8_2.dto;

import com.mattjohnson.teai8_2.entity.Note;
import lombok.Data;

@Data
public class NoteDto {

    private Integer id;

    private String title;

    private String content;

    private Integer userId;

    public NoteDto(Note note) {
        this.id = note.getId();
        this.title = note.getTitle();
        this.content = note.getContent();
        this.userId = note.getUser().getId();
    }

    public NoteDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
