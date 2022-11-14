package com.epam.spring.library.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(number, user.number) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(phone, user.phone) && status == user.status && Objects.equals(photo, user.photo) && role == user.role && Objects.equals(locale, user.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, password, firstName, lastName, email, dateOfBirth, phone, status, photo, role, locale);
    }
}
