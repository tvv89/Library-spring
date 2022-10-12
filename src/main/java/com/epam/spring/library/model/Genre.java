package com.epam.spring.library.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@EqualsAndHashCode
@Component
public class Genre {
    private long id;
    private String name;
}
