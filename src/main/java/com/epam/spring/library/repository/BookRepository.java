package com.epam.spring.library.repository;

import com.epam.spring.library.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    List<Book> findAll();

}
