package com.epam.spring.library.service;

import com.epam.spring.library.model.Publisher;

import java.util.List;


public interface PublisherService {

    List<Publisher> getAllPublishers();
    Publisher createPublisher(Publisher publisher);
    Publisher getPublisherById(long id);
    Publisher updatePublisher(Publisher publisher);

    void deletePublisher(Publisher publisher);
}
