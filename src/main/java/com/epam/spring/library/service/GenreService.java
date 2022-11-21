package com.epam.spring.library.service;

import com.epam.spring.library.model.Genre;

import java.util.List;


public interface GenreService {

    List<Genre> getAllGenres();
    Genre createGenre(Genre genre);
    Genre getGenreById(long id);
    Genre updateGenre(Genre genre);

    void deleteGenre(Genre genre);
}
