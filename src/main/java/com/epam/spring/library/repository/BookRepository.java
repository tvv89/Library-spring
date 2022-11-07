package com.epam.spring.library.repository;

import com.epam.spring.library.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    List<Book> findAll();

    @Query("select b from Book b where b.publisher.name = ?1 order by b.publisher.name")
    List<Book> findBooksByPublisherName(String publisher);

    @Query("SELECT b FROM Book b join b.genres g join fetch b.genres where g.name = :genre")
    List<Book> findBooksByGenre(@Param("genre") String genre);

    List<Book> findBooksByAuthorLastName(String lastName);
    Book findBookByISBNCustom(String isbn);

}
