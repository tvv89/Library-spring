package com.epam.spring.library.service.impl;

import com.epam.spring.library.model.Genre;
import com.epam.spring.library.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;
import java.util.Objects;

@Service
public class GenreServiceImpl implements GenreService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GenreServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Genre> getAllGenres() {
        return jdbcTemplate.query(
                "select id, name from genres",
                (rs, rowNum) -> {
                    Genre genre = new Genre();
                    genre.setId(rs.getLong("id"));
                    genre.setName(rs.getString("name"));
                    return genre;
                });
    }

    @Override
    public Genre createGenre(Genre genre) {
        long id;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("insert into genres values(0, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, genre.getName());
            return ps;
        }, keyHolder);
        id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        Genre result = new Genre();
        result.setId(id);
        result.setName(genre.getName());
        return result;
    }

    @Override
    public Genre getGenreById(long id) {
        return jdbcTemplate.queryForObject(
                "select id, name from genres where id = ?",
                new Object[]{id}, new int[]{Types.INTEGER},
                (rs, rowNum) -> {
                    Genre result = new Genre();
                    result.setId(rs.getLong("id"));
                    result.setName(rs.getString("name"));
                    return result;
                });
    }

    @Override
    public Genre updateGenre(Genre genre) {
        jdbcTemplate.update(
                "update genres set name = ? where id = ?",
                genre.getName(), genre.getId());
        return genre;
    }

    @Override
    public void deleteGenre(Genre genre) {
        jdbcTemplate.update(
                "delete from genres where id = ?",
                genre.getId());
    }
}
