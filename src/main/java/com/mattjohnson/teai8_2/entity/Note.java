package com.mattjohnson.teai8_2.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title cannot be blank.")
    @Length(min = 1, max = 255, message = "The required number of characters in the title is 1-255")
    private String title;

    @Type(type = "text")
    private String content;

    private ZonedDateTime creationDate = ZonedDateTime.now();

    private ZonedDateTime modificationDate;

    private ZonedDateTime removalDate;

    @Column(columnDefinition = "boolean default false")
    private boolean removed;

    @ManyToOne
    private User user;

}
