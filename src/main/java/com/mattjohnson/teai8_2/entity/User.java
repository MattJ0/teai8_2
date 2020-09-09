package com.mattjohnson.teai8_2.entity;

import com.mattjohnson.teai8_2.dto.UserDto;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is mandatory and cannot be blank.")
    @Length(min = 8, max = 25, message = "The required number of characters in the name is 8-25")
    private String name;

    @NotBlank(message = "Email is mandatory and cannot be blank.")
    @Email()
    private String email;

    private ZonedDateTime creationDate;

    @OneToMany(mappedBy = "user")
    private Set<Note> noteSet;

    public User(UserDto userDto) {
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.creationDate = ZonedDateTime.now();
    }
}