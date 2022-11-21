package com.epam.spring.library.service;

import com.epam.spring.library.model.User;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(long id);
    User updateUser(User user);

    void deleteUser(User user);
}
