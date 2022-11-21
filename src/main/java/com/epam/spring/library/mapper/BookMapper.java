package com.epam.spring.library.mapper;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    List<BookDTO> mapListOfBooksDTO(List<Book> books);

    List<Book> mapListOfBooks(List<BookDTO> booksDTO);

    BookDTO mapBookDTO (Book book);

    Book mapBook(BookDTO bookDTO);

}
