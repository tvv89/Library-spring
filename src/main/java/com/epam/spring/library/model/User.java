package com.epam.spring.library.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@Component
public class User {
    private long id;
    private String number;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String phone;
    private StatusUser status;
    private String photo;
    private Role role;
    private String locale;
}
