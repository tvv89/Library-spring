package com.epam.spring.library.service;

import com.epam.spring.library.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(long id);
    User updateUser(User user);
    User deleteUser(User user);

}
