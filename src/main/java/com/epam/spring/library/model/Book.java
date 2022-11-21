package com.epam.spring.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "books")
@NamedQuery(name = "Book.findBooksByAuthorLastName",
            query = "SELECT b FROM Book b join b.authors a join fetch b.authors where a.lastName = :lastName")
@NamedNativeQuery(name = "Book.findBookByISBNCustom",
        query = "SELECT * FROM books where isbn = :isbn",
        resultClass = Book.class)

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;
    @OneToOne
    private Publisher publisher;
    @Column(name = "years")
    private String years;
    @ManyToMany
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;
    @Column(name = "image")
    private String image;
    @Column(name = "count")
    private int count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && count == book.count && Objects.equals(isbn, book.isbn)
                && Objects.equals(name, book.name) && Objects.equals(authors, book.authors)
                && Objects.equals(publisher, book.publisher) && Objects.equals(years, book.years)
                && Objects.equals(genres, book.genres) && Objects.equals(image, book.image);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
