package com.epam.spring.library.dto;

import com.epam.spring.library.validator.DateConstraint;
import com.epam.spring.library.validator.PhoneConstraint;
import lombok.*;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Positive
    private long id;
    @NotBlank (message = "{message.validation.user.not_blank}")
    @NotEmpty (message = "{message.validation.user.not_empty}")
    @NotNull (message = "{message.validation.user.not_empty}")
    private String number;
    @NotBlank (message = "{message.validation.user.not_blank}")
    @NotEmpty (message = "{message.validation.user.not_empty}")
    private String password;
    @Email (message = "{message.validation.user.email}")
    private String email;
    @NotBlank (message = "{message.validation.user.not_blank}")
    @NotEmpty (message = "{message.validation.user.not_empty}")
    private String firstName;
    @NotBlank (message = "{message.validation.user.not_blank}")
    @NotEmpty (message = "{message.validation.user.not_empty}")
    private String lastName;
    @DateConstraint (message = "{message.validation.user.date}")
    private String dateOfBirth;
    @PhoneConstraint (message = "{message.validation.user.phone}")
    private String phone;
    private String status;
    private String photo;
    private String role;
    private String locale;
}
