package com.epam.spring.library.repository;

import com.epam.spring.library.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findAll();
    @Query ("select u from User u where u.number = ?1")
    User findUserByNumber(String number);

}
