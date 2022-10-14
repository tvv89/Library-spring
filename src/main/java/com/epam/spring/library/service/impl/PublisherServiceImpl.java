package com.epam.spring.library.service.impl;

import com.epam.spring.library.model.Publisher;
import com.epam.spring.library.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Override
    public List<Publisher> getAllPublishers() {
        return List.of();
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        return new Publisher();
    }

    @Override
    public Publisher getPublisherById(long id) {
        return new Publisher();
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return new Publisher();
    }

    @Override
    public void deletePublisher(Publisher publisher) {

    }
}
