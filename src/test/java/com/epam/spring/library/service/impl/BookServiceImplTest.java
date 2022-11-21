package com.epam.spring.library.service.impl;

import com.epam.spring.library.model.Book;
import com.epam.spring.library.repository.BookRepository;
import com.epam.spring.library.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testGetAllBooks() {
        Book book = TestUtils.createBook();
        List<Book> books = List.of(book);
        when(bookRepository.findAll()).thenReturn(books);
        assertEquals(books, bookService.getAllBooks());
    }

    @Test
    void testCreateBook() {
        Book book = TestUtils.createBook();
        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(book, bookService.createBook(book));
    }

    @Test
    void testGetBookById() {
        Book book = TestUtils.createBook();
        when(bookRepository.findById(TestUtils.BOOK_ID)).thenReturn(Optional.of(book));
        assertEquals(book, bookService.getBookById(1L));
    }

    @Test
    void testUpdateBook() {
        Book book = TestUtils.createBook();
        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(book, bookService.updateBook(book));
    }

    @Test
    void testDeleteBook() {
        Book book = TestUtils.createBook();
        bookService.deleteBook(book);
        verify(bookRepository, times(1)).delete(book);
    }

    @Test
    void testFindBooksByGenre() {
        Book book = TestUtils.createBook();
        List<Book> books = List.of(book);
        when(bookRepository.findBooksByGenre(TestUtils.GENRE_NAME)).thenReturn(books);
        assertEquals(books, bookService.findBooksByGenre(TestUtils.GENRE_NAME));
    }

    @Test
    void testFindBooksByAuthorLastName() {
        Book book = TestUtils.createBook();
        List<Book> books = List.of(book);
        when(bookRepository.findBooksByAuthorLastName(TestUtils.AUTHOR_LAST_NAME)).thenReturn(books);
        assertEquals(books, bookService.findBooksByAuthorLastName(TestUtils.AUTHOR_LAST_NAME));
    }

    @Test
    void testFindBookByISBN() {
        Book book = TestUtils.createBook();
        when(bookRepository.findBookByISBNCustom(TestUtils.BOOK_ISBN)).thenReturn(book);
        assertEquals(book, bookService.findBookByISBN(TestUtils.BOOK_ISBN));
    }
}