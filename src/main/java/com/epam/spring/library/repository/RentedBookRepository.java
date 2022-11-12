package com.epam.spring.library.repository;

import com.epam.spring.library.model.Book;
import com.epam.spring.library.model.RentedBook;
import com.epam.spring.library.model.StatusPayRentedBook;
import com.epam.spring.library.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentedBookRepository extends PagingAndSortingRepository<RentedBook, Long> {
    List<RentedBook> getRentedBooks();
    List<RentedBook> findRentedBooksByUser (User user);
    List<RentedBook> findRentedBooksByBook (Book book);
    List<RentedBook> findRentedBooksByStatus(StatusPayRentedBook status);
}
