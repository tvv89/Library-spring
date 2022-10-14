package com.epam.spring.library.mapper;

import com.epam.spring.library.dto.GenreDTO;
import com.epam.spring.library.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    List<GenreDTO> mapListOfGenresDTO(List<Genre> Genres);

    List<Genre> mapListOfGenres(List<GenreDTO> GenresDTO);

    GenreDTO mapGenreDTO (Genre Genre);

    Genre mapGenre(GenreDTO GenreDTO);

}
