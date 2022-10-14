package com.epam.spring.library.dto;

import com.epam.spring.library.model.Book;
import com.epam.spring.library.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentedBookDTO {
    @Valid
    @Positive
    private long id;
    private Book book;
    private User user;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
