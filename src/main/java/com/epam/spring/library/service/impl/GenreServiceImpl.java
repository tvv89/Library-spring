package com.epam.spring.library.service.impl;

import com.epam.spring.library.model.Genre;
import com.epam.spring.library.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    
    @Override
    public List<Genre> getAllGenres() {
        return List.of();
    }

    @Override
    public Genre createGenre(Genre genre) {
        return new Genre();
    }

    @Override
    public Genre getGenreById(long id) {
        return new Genre();
    }

    @Override
    public Genre updateGenre(Genre genre) {
        return new Genre();
    }

    @Override
    public void deleteGenre(Genre genre) {
        
    }
}
