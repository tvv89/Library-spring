package com.epam.spring.library.controller;

import com.epam.spring.library.dto.GenreDTO;
import com.epam.spring.library.mapper.GenreMapper;
import com.epam.spring.library.model.Genre;
import com.epam.spring.library.service.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping()
    public List<GenreDTO> getGenres() {
        log.info("Show all genres");
        return GenreMapper.INSTANCE.mapListOfGenresDTO(genreService.getAllGenres());
    }

    @GetMapping("/{id}")
    public GenreDTO getGenreById(@PathVariable("id") long id) {
        log.info("Show genre by id " + id);
        return GenreMapper.INSTANCE.mapGenreDTO(genreService.getGenreById(id));
    }

    @PostMapping()
    public GenreDTO createGenre(@RequestBody GenreDTO genreDTO) {
        log.info("Creat genres by request " + genreDTO);
        Genre genre = GenreMapper.INSTANCE.mapGenre(genreDTO);
        return GenreMapper.INSTANCE.mapGenreDTO(genreService.createGenre(genre));
    }

    @DeleteMapping("/{id}")
    public GenreDTO deleteGenre(@PathVariable("id") long id) {
        log.info("Delete genre by id " + id);
        Genre genre = genreService.getGenreById(id);
        genreService.deleteGenre(genre);
        log.info("This genre will be deleted: " + genre);
        return GenreMapper.INSTANCE.mapGenreDTO(genre);
    }

    @PutMapping()
    public GenreDTO updateGenre(@RequestBody @Valid GenreDTO genreDTO) {
        log.info("Update genre: " + genreDTO);
        Genre genre = genreService.updateGenre(GenreMapper.INSTANCE.mapGenre(genreDTO));
        log.debug("This genre was updated: " + genre);
        return GenreMapper.INSTANCE.mapGenreDTO(genre);
    }


}
