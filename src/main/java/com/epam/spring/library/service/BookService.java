package com.epam.spring.library.service;

import com.epam.spring.library.model.Book;

import java.util.List;


public interface BookService {

    List<Book> getAllBooks();
    Book createBook(Book book);
    Book getBookById(long id);
    Book updateBook(Book book);

    void deleteBook(Book book);
}
