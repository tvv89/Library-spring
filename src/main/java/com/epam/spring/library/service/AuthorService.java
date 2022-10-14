package com.epam.spring.library.service;

import com.epam.spring.library.model.Author;

import java.util.List;


public interface AuthorService {

    List<Author> getAllAuthors();
    Author createAuthor(Author author);
    Author getAuthorById(long id);
    Author updateAuthor(Author author);

    void deleteAuthor(Author author);
}
