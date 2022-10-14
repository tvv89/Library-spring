package com.epam.spring.library.controller;

import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.mapper.BookMapper;
import com.epam.spring.library.model.Book;
import com.epam.spring.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping()
    public List<BookDTO> getBooks() {
        log.info("Show all books");
        return BookMapper.INSTANCE.mapListOfBooksDTO(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable("id") long id) {
        log.info("Show book by id " + id);
        return BookMapper.INSTANCE.mapBookDTO(bookService.getBookById(id));
    }

    @PostMapping()
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        log.info("Creat books by request " + bookDTO);
        Book book = BookMapper.INSTANCE.mapBook(bookDTO);
        return BookMapper.INSTANCE.mapBookDTO(bookService.createBook(book));
    }

    @DeleteMapping("/{id}")
    public BookDTO deleteBook(@PathVariable("id") long id) {
        log.info("Delete book by id " + id);
        Book book = bookService.getBookById(id);
        bookService.deleteBook(book);
        log.info("This book will be deleted: " + book);
        return BookMapper.INSTANCE.mapBookDTO(book);
    }

    @PutMapping()
    public BookDTO updateBook(@RequestBody @Valid BookDTO bookDTO) {
        log.info("Update book: " + bookDTO);
        Book book = bookService.updateBook(BookMapper.INSTANCE.mapBook(bookDTO));
        log.debug("This book was updated: " + book);
        return BookMapper.INSTANCE.mapBookDTO(book);
    }


}