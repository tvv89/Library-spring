package com.epam.spring.library.mapper;

import com.epam.spring.library.dto.PublisherDTO;
import com.epam.spring.library.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    List<PublisherDTO> mapListOfPublishersDTO(List<Publisher> Publishers);

    List<Publisher> mapListOfPublishers(List<PublisherDTO> PublishersDTO);

    PublisherDTO mapPublisherDTO (Publisher Publisher);

    Publisher mapPublisher(PublisherDTO PublisherDTO);

}
