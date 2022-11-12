package com.epam.spring.library.mapper;

import com.epam.spring.library.dto.RentedBookDTO;
import com.epam.spring.library.model.Book;
import com.epam.spring.library.model.RentedBook;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RentBookMapper {

    RentBookMapper INSTANCE = Mappers.getMapper(RentBookMapper.class);

    List<RentedBookDTO> mapListOfBooksDTO(List<RentedBook> books);

    List<RentedBook> mapListOfBooks(List<RentedBookDTO> booksDTO);

    RentedBookDTO mapRentedBookDTO (RentedBook book);

    Book mapBook(RentedBookDTO bookDTO);

}
