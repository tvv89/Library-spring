package com.epam.spring.library.service.impl;

import com.epam.spring.library.model.User;
import com.epam.spring.library.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUsers() {
        return List.of(new User(), new User(), new User());
    }

    @Override
    public User createUser(User user) {
        return user;
    }

    @Override
    public User getUserById(long id) {
        return new User();
    }

    @Override
    public User updateUser(User user) {
        return user;
    }

    @Override
    public User deleteUser(User user) {
        return user;
    }
}
