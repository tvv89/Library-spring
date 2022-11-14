package com.epam.spring.library.service.impl;

import com.epam.spring.library.model.Publisher;
import com.epam.spring.library.repository.PublisherRepository;
import com.epam.spring.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return (List<Publisher>) publisherRepository.findAll();
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getPublisherById(long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisher(Publisher publisher) {
        publisherRepository.delete(publisher);
    }
}
