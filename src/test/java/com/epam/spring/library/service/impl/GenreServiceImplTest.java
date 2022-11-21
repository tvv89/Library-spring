package com.epam.spring.library.service.impl;

import com.epam.spring.library.model.Genre;
import com.epam.spring.library.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenreServiceImplTest {

    @InjectMocks
    private GenreServiceImpl genreService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    void getAllGenres() {
        String selectQuery = "select id, name from genres";
        List<Genre> genres = List.of(TestUtils.createGenre());
        when(jdbcTemplate.query(eq(selectQuery),
                any(RowMapper.class))).thenReturn(genres);
        assertEquals(genres, genreService.getAllGenres());
    }

    @Test
    void createGenre() {
        Genre genre = TestUtils.createGenre();
        when(jdbcTemplate.update(any(PreparedStatementCreator.class),
                any(KeyHolder.class))).thenAnswer(invocation -> {
               Object[] args = invocation.getArguments();
               Map<String, Object> keyMap = new HashMap<>();
               keyMap.put("GENERATED_KEY", 1);
               ((GeneratedKeyHolder)args[1]).getKeyList().add(keyMap);
               return 1;
           }).thenReturn(1);
        assertEquals(genre, genreService.createGenre(genre));
    }

    @Test
    void getGenreById() {
        String selectQuery = "select id, name from genres where id = ?";
        Genre genre = TestUtils.createGenre();
        when(jdbcTemplate.queryForObject(eq(selectQuery), eq(new Object[]{1L}), eq(new int[]{Types.INTEGER}),
                any(RowMapper.class))).thenReturn(genre);
        assertEquals(genre, genreService.getGenreById(1L));
    }

    @Test
    void updateGenre() {
        String selectQuery = "update genres set name = ? where id = ?";
        Genre genre = TestUtils.createGenre();
        genreService.updateGenre(genre);
        verify(jdbcTemplate, times(1)).update(eq(selectQuery),
                eq(TestUtils.GENRE_NAME), eq(TestUtils.GENRE_ID));
    }

    @Test
    void deleteGenre() {
        String selectQuery = "delete from genres where id = ?";
        Genre genre = TestUtils.createGenre();
        genreService.deleteGenre(genre);
        verify(jdbcTemplate, times(1)).update(eq(selectQuery),
                eq(TestUtils.GENRE_ID));
    }
}