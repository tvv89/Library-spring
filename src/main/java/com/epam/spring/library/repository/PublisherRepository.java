package com.epam.spring.library.repository;

import com.epam.spring.library.model.Publisher;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long> {


}
