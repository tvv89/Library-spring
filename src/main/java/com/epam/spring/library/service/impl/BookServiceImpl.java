package com.epam.spring.library.service.impl;

import com.epam.spring.library.model.Book;
import com.epam.spring.library.repository.BookRepository;
import com.epam.spring.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).orElse(null);

    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public List<Book> findBooksByGenre(String genre) {
        return bookRepository.findBooksByGenre(genre);
    }

    @Override
    public List<Book> findBooksByAuthorLastName(String lastName) {
        return bookRepository.findBooksByAuthorLastName(lastName);
    }

    @Override
    public Book findBookByISBN(String isbn) {
        return bookRepository.findBookByISBNCustom(isbn);
    }


}
