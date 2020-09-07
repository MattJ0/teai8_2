package com.mattjohnson.teai8_2.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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

    @OneToMany
    private Set<Note> noteSet;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
