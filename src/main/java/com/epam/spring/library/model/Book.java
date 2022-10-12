package com.epam.spring.library.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Component
public class Book {
    private long id;
    private String isbn;
    private String name;
    private Set<Author> authors;
    private Publisher publisher;
    private String year;
    private Set<Genre> genres;
    private String image;
    private int count;
}
