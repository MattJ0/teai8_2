package com.mattjohnson.teai8_2.entity;

import com.mattjohnson.teai8_2.dto.NoteDto;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Entity
@Table(name = "notes")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title cannot be blank.")
    @Length(min = 1, max = 255, message = "The required number of characters in the title is 1-255")
    private String title;

    @Type(type = "text")
    private String content;

    private ZonedDateTime creationDate;

    private ZonedDateTime modificationDate;

    private ZonedDateTime removalDate;

    private boolean isRemoved;

    @ManyToOne
    private User user;

    public Note(NoteDto noteDto) {
        this.title = noteDto.getTitle();
        this.content = noteDto.getContent();
        this.creationDate = ZonedDateTime.now();
        this.user.setId(noteDto.getUserId());
    }
}
