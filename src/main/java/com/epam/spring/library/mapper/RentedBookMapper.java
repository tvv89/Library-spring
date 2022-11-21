package com.epam.spring.library.mapper;

import com.epam.spring.library.dto.RentedBookDTO;
import com.epam.spring.library.model.RentedBook;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RentedBookMapper {
    RentedBookMapper INSTANCE = Mappers.getMapper(RentedBookMapper.class);

    List<RentedBookDTO> mapListOfRentedBooksDTO(List<RentedBook> RentedBooks);

    List<RentedBook> mapListOfRentedBooks(List<RentedBookDTO> RentedBooksDTO);

    RentedBookDTO mapRentedBookDTO (RentedBook RentedBook);

    RentedBook mapRentedBook(RentedBookDTO RentedBookDTO);

}
