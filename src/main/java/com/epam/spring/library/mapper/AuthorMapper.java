package com.epam.spring.library.mapper;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    List<AuthorDTO> mapListOfAuthorsDTO(List<Author> authors);

    List<Author> mapListOfAuthors(List<AuthorDTO> authorsDTO);

    AuthorDTO mapAuthorDTO (Author author);

    Author mapAuthor(AuthorDTO authorDTO);

}
