package com.epam.spring.library.controller;

import com.epam.spring.library.dto.RentedBookDTO;
import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.mapper.RentedBookMapper;
import com.epam.spring.library.model.RentedBook;
import com.epam.spring.library.service.RentedBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rent-books")
@RequiredArgsConstructor
public class RentBookController {

    private final RentedBookService rentedBookService;


    @GetMapping()
    public List<RentedBookDTO> getBooks() {
        log.info("Show all rented books");
        return RentedBookMapper.INSTANCE.mapListOfRentedBooksDTO(rentedBookService.getAllRentedBooks());
    }

    @GetMapping("/{id}")
    public RentedBookDTO getBookById(@PathVariable("id") long id) {
        log.info("Show rented book by id " + id);
        RentedBook book = rentedBookService.getRentedBookById(id);
        if (book == null) throw new EntityNotFoundException("rented book not found");
        return RentedBookMapper.INSTANCE.mapRentedBookDTO(book);
    }

    @PostMapping()
    public RentedBookDTO createBook(@RequestBody RentedBookDTO rentedBookDTO) {
        log.info("Creat rented books by request " + rentedBookDTO);
        RentedBook book = RentedBookMapper.INSTANCE.mapRentedBook(rentedBookDTO);
        book.setStartDate(LocalDate.now());
        book.setEndDate(LocalDate.now().plusDays(14));
        return RentedBookMapper.INSTANCE.mapRentedBookDTO(rentedBookService.createRentedBook(book));
    }

    @DeleteMapping("/{id}")
    public RentedBookDTO deleteBook(@PathVariable("id") long id) {
        log.info("Delete rented book by id " + id);
        RentedBook book = rentedBookService.getRentedBookById(id);
        if (book == null) throw new EntityNotFoundException("rented book not found");
        rentedBookService.deleteRentedBook(book);
        log.info("This rented book will be deleted: " + book);
        return RentedBookMapper.INSTANCE.mapRentedBookDTO(book);
    }

}
