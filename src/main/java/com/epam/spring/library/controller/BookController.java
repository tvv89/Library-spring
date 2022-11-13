package com.epam.spring.library.controller;

import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.exception.EntityNotFoundException;
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
        Book book = bookService.getBookById(id);
        if (book == null) throw new EntityNotFoundException("book not found");
        return BookMapper.INSTANCE.mapBookDTO(book);
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
        if (book == null) {
            log.debug("Book by id " + id + " not found");
            throw new EntityNotFoundException("Book not found");
        }
        bookService.deleteBook(book);
        log.info("This book was deleted: " + book);
        return BookMapper.INSTANCE.mapBookDTO(book);
    }

    @GetMapping("/find-by-genre")
    public List<BookDTO> findBooksByGenre(@RequestParam String genre) {
        log.info("Find books by genre " + genre);
        return BookMapper.INSTANCE.mapListOfBooksDTO(bookService.findBooksByGenre(genre));
    }

    @GetMapping("/find-by-author")
    public List<BookDTO> findBooksByAuthorLastName(@RequestParam(name = "last-name") String lastName) {
        log.info("Find books by author " + lastName);
        return BookMapper.INSTANCE
                .mapListOfBooksDTO(bookService.findBooksByAuthorLastName(lastName));
    }

    @GetMapping("/find-by-isbn")
    public BookDTO findBooksByISBN(@RequestParam(name = "isbn") String isbn) {
        log.info("Find books by ISBN " + isbn);
        return BookMapper.INSTANCE
                .mapBookDTO(bookService.findBookByISBN(isbn));
    }

    @PutMapping()
    public BookDTO updateBook(@RequestBody @Valid BookDTO bookDTO) {
        log.info("Update book: " + bookDTO);
        Book book = bookService.updateBook(BookMapper.INSTANCE.mapBook(bookDTO));
        log.debug("This book was updated: " + book);
        return BookMapper.INSTANCE.mapBookDTO(book);
    }


}
