package com.epam.spring.library.dto;

import com.epam.spring.library.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull
    @NotBlank
    private String isbn;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private Set<AuthorDTO> authors;
    @NotNull
    @NotBlank
    private Publisher publisher;
    @NotNull
    @NotBlank
    private String years;
    private Set<GenreDTO> genres;
    private String image;
    @NotNull
    @NotBlank
    private int count;
}
