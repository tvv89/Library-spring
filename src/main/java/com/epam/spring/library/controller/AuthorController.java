package com.epam.spring.library.controller;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.mapper.AuthorMapper;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping()
    public List<AuthorDTO> getAuthors() {
        log.info("Show all authors");
        return AuthorMapper.INSTANCE.mapListOfAuthorsDTO(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable("id") long id) {
        log.info("Show author by id " + id);
        return AuthorMapper.INSTANCE.mapAuthorDTO(authorService.getAuthorById(id));
    }

    @PostMapping()
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO) {
        log.info("Creat authors by request " + authorDTO);
        Author author = AuthorMapper.INSTANCE.mapAuthor(authorDTO);
        return AuthorMapper.INSTANCE.mapAuthorDTO(authorService.createAuthor(author));
    }

    @DeleteMapping("/{id}")
    public AuthorDTO deleteAuthor(@PathVariable("id") long id) {
        log.info("Delete author by id " + id);
        Author author = authorService.getAuthorById(id);
        authorService.deleteAuthor(author);
        log.info("This author will be deleted: " + author);
        return AuthorMapper.INSTANCE.mapAuthorDTO(author);
    }

    @PutMapping()
    public AuthorDTO updateAuthor(@RequestBody @Valid AuthorDTO authorDTO) {
        log.info("Update author: " + authorDTO);
        Author author = authorService.updateAuthor(AuthorMapper.INSTANCE.mapAuthor(authorDTO));
        log.debug("This author was updated: " + author);
        return AuthorMapper.INSTANCE.mapAuthorDTO(author);
    }


}
