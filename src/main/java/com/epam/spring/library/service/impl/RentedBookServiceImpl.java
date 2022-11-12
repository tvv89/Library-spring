package com.epam.spring.library.service.impl;

import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Book;
import com.epam.spring.library.model.RentedBook;
import com.epam.spring.library.model.StatusPayRentedBook;
import com.epam.spring.library.model.User;
import com.epam.spring.library.repository.BookRepository;
import com.epam.spring.library.repository.RentedBookRepository;
import com.epam.spring.library.repository.UserRepository;
import com.epam.spring.library.service.RentedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RentedBookServiceImpl implements RentedBookService {

    public final RentedBookRepository rentedBookRepository;

    public final BookRepository bookRepository;

    public final UserRepository userRepository;

    @Autowired
    public RentedBookServiceImpl(RentedBookRepository rentedBookRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.rentedBookRepository = rentedBookRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<RentedBook> getAllRentedBooks() {
        return rentedBookRepository.getRentedBooks();
    }

    @Override
    public RentedBook createRentedBook(RentedBook book) {
        Book updateBook = bookRepository.findById(book.getBook().getId()).orElse(null);
        if (updateBook == null) throw new EntityNotFoundException("book not found");
        int count = updateBook.getCount() - 1;
        updateBook.setCount(count);
        bookRepository.save(updateBook);
        return rentedBookRepository.save(book);
    }

    @Override
    public RentedBook getRentedBookById(long id) {
        return rentedBookRepository.findById(id).orElse(null);
    }

    @Override
    public RentedBook updateRentedBook(RentedBook book) {
        return rentedBookRepository.save(book);
    }

    @Override
    public RentedBook updateRentedBookStatus(RentedBook rentedBook, StatusPayRentedBook status) {
        rentedBook.setStatus(status);
        return rentedBookRepository.save(rentedBook);
    }

    @Override
    @Transactional
    public void deleteRentedBook(RentedBook book) {
        RentedBook checkBook = rentedBookRepository.findById(book.getId()).orElse(null);
        if (checkBook == null) throw new EntityNotFoundException("rented book not found: " + book);
        Book updateBook = bookRepository.findById(checkBook.getBook().getId()).orElse(null);
        if (updateBook == null) throw new EntityNotFoundException("book not found");
        int count = updateBook.getCount() + 1;
        updateBook.setCount(count);
        bookRepository.save(updateBook);
        rentedBookRepository.delete(book);
    }

    @Override
    @Transactional
    public List<RentedBook> findRentedBooksByUser(User user) {
        User userCheck = userRepository.findById(user.getId()).orElse(null);
        if (userCheck == null) throw new EntityNotFoundException("user not found");
        return rentedBookRepository.findRentedBooksByUser(user);
    }

    @Override
    @Transactional
    public List<RentedBook> findRentedBooksByBook(Book book) {
        Book bookCheck = bookRepository.findById(book.getId()).orElse(null);
        if (bookCheck == null) throw new EntityNotFoundException("book not found");
        return rentedBookRepository.findRentedBooksByBook(book);
    }

    @Override
    public List<RentedBook> findRentedBooksByStatus(StatusPayRentedBook status) {
        return rentedBookRepository.findRentedBooksByStatus(status);
    }
}
