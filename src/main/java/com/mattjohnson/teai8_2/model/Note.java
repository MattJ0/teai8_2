package com.mattjohnson.teai8_2.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
