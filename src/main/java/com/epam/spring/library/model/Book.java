package com.epam.spring.library.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Component
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
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
    @Column(name = "year")
    private String year;
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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
