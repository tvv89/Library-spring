package com.epam.spring.library.service;

import com.epam.spring.library.model.Book;
import com.epam.spring.library.model.RentedBook;
import com.epam.spring.library.model.StatusPayRentedBook;
import com.epam.spring.library.model.User;

import java.util.List;


public interface RentedBookService {

    List<RentedBook> getAllRentedBooks();
    RentedBook createRentedBook(RentedBook book);
    RentedBook getRentedBookById(long id);
    RentedBook updateRentedBook(RentedBook book);

    RentedBook updateRentedBookStatus(RentedBook rentedBook, StatusPayRentedBook status);

    void deleteRentedBook(RentedBook book);

    List<RentedBook> findRentedBooksByUser (User user);
    List<RentedBook> findRentedBooksByBook (Book book);
    List<RentedBook> findRentedBooksByStatus(StatusPayRentedBook status);

}
