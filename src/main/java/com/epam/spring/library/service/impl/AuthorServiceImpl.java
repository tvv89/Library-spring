package com.epam.spring.library.service.impl;

import com.epam.spring.library.model.Author;
import com.epam.spring.library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Override
    public List<Author> getAllAuthors() {
        return List.of();
    }

    @Override
    public Author createAuthor(Author author) {
        return new Author();
    }

    @Override
    public Author getAuthorById(long id) {
        return new Author();
    }

    @Override
    public Author updateAuthor(Author author) {
        return new Author();
    }

    @Override
    public void deleteAuthor(Author author) {

    }
}
