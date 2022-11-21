package com.epam.spring.library.controller;

import com.epam.spring.library.dto.PublisherDTO;
import com.epam.spring.library.mapper.PublisherMapper;
import com.epam.spring.library.model.Publisher;
import com.epam.spring.library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping()
    public List<PublisherDTO> getPublishers() {
        log.info("Show all publishers");
        return PublisherMapper.INSTANCE.mapListOfPublishersDTO(publisherService.getAllPublishers());
    }

    @GetMapping("/{id}")
    public PublisherDTO getPublisherById(@PathVariable("id") long id) {
        log.info("Show publisher by id " + id);
        return PublisherMapper.INSTANCE.mapPublisherDTO(publisherService.getPublisherById(id));
    }

    @PostMapping()
    public PublisherDTO createPublisher(@RequestBody PublisherDTO publisherDTO) {
        log.info("Creat publishers by request " + publisherDTO);
        Publisher publisher = PublisherMapper.INSTANCE.mapPublisher(publisherDTO);
        return PublisherMapper.INSTANCE.mapPublisherDTO(publisherService.createPublisher(publisher));
    }

    @DeleteMapping("/{id}")
    public PublisherDTO deletePublisher(@PathVariable("id") long id) {
        log.info("Delete publisher by id " + id);
        Publisher publisher = publisherService.getPublisherById(id);
        publisherService.deletePublisher(publisher);
        log.info("This publisher will be deleted: " + publisher);
        return PublisherMapper.INSTANCE.mapPublisherDTO(publisher);
    }

    @PutMapping()
    public PublisherDTO updatePublisher(@RequestBody @Valid PublisherDTO publisherDTO) {
        log.info("Update publisher: " + publisherDTO);
        Publisher publisher = publisherService.updatePublisher(PublisherMapper.INSTANCE.mapPublisher(publisherDTO));
        log.debug("This publisher was updated: " + publisher);
        return PublisherMapper.INSTANCE.mapPublisherDTO(publisher);
    }


}
