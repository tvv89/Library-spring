package com.epam.spring.library.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Valid
    @Positive
    private long id;
    @Valid
    @NotBlank
    @NotEmpty
    private String number;
    @Valid
    @NotBlank
    @NotEmpty
    private String password;
    @Valid
    @Email
    private String email;
    @Valid
    @NotBlank
    @NotEmpty
    private String firstName;
    @Valid
    @NotBlank
    @NotEmpty
    private String lastName;
    private String dateOfBirth;
    private String phone;
    private String status;
    private String photo;
    private String role;
    private String locale;
}
