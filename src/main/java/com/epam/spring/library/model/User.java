package com.epam.spring.library.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@Component
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "number")
    private String number;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "phone")
    private String phone;
    @Column(name = "status")
    private StatusUser status;
    @Column(name = "photo")
    private String photo;
    @Column(name = "role_id")
    private Role role;
    @Column(name = "locale")
    private String locale;
}
