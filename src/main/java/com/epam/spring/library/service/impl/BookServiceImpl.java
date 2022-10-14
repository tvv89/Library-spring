package com.epam.spring.library.service.impl;

import com.epam.spring.library.model.Book;
import com.epam.spring.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    
    @Override
    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public Book createBook(Book book) {
        return new Book();
    }

    @Override
    public Book getBookById(long id) {
        return new Book();
    }

    @Override
    public Book updateBook(Book book) {
        return new Book();
    }

    @Override
    public void deleteBook(Book book) {
        
    }
}
