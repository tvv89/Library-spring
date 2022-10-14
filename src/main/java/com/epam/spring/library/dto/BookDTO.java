package com.epam.spring.library.dto;

import com.epam.spring.library.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    @Valid
    @Positive
    private long id;
    private String isbn;
    private String name;
    private Set<AuthorDTO> authors;
    private Publisher publisher;
    private String year;
    private Set<GenreDTO> genres;
    private String image;
    private int count;
}
