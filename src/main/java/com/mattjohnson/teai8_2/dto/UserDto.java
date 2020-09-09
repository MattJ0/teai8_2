package com.mattjohnson.teai8_2.dto;

import com.mattjohnson.teai8_2.entity.User;
import lombok.Data;

@Data
public class UserDto {

    // w DTO odbicie encji (w zakresie udostęþnianych danych), mapowanie w serwisie
    // Output - z serwisu do controllera trafia DTO i jest przerabiane przez assembler zasobów
    // Input - z controllera do serwisu jest przekazywane DTO, serwis mapuje na encję i przekazuje do repo

    //dodać logger @Slf4j

    private Integer id;

    private String name;

    private String email;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
