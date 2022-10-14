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
public class RentedBook {
    private long id;
    private Book book;
    private User user;
    private LocalDate startDate;
    private LocalDate endDate;
    private StatusPayRentedBook status;

}
