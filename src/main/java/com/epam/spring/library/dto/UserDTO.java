package com.epam.spring.library.dto;

import com.epam.spring.library.validator.DateConstraint;
import com.epam.spring.library.validator.PhoneConstraint;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDTO {
    @Id
    @Positive
    private long id;
    @NotBlank
    @NotEmpty
    @NotNull
    private String number;
    @NotBlank
    @NotEmpty
    private String password;
    @Email
    private String email;
    @NotBlank
    @NotEmpty
    private String firstName;
    @NotBlank
    @NotEmpty
    private String lastName;
    @DateConstraint
    private String dateOfBirth;
    @PhoneConstraint
    private String phone;
    private String status;
    private String photo;
    private String role;
    private String locale;
}
