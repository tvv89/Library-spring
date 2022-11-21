package com.epam.spring.library.service.impl;

import com.epam.spring.library.model.User;
import com.epam.spring.library.repository.UserRepository;
import com.epam.spring.library.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetUsers() {
        User user = TestUtils.createUser();
        List<User> users = List.of(user);
        when(userRepository.findAll()).thenReturn(users);
        assertEquals(users, userService.getAllUsers());
    }

    @Test
    void testGetNoUsers() {
        List<User> users = List.of();
        when(userRepository.findAll()).thenReturn(users);
        assertEquals(users, userService.getAllUsers());
    }

    @Test
    void testGetUserById() {
        User user = TestUtils.createUser();
        when(userRepository.findById(TestUtils.USER_ID)).thenReturn(Optional.of(user));
        assertEquals(user, userService.getUserById(2L));
    }

    @Test
    void testGetUserByIdNotFound() {
        when(userRepository.findById(TestUtils.USER_ID)).thenReturn(Optional.empty());
        assertNull(userService.getUserById(2L));
    }

    @Test
    void testCreateUser() {
        User user = TestUtils.createUser();
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.createUser(user));
    }

    @Test
    void testDeleteUser() {
        User user = TestUtils.createUser();
        userService.deleteUser(user);
        verify(userRepository, times(1)).delete(user);
    }

    @Test
    void testUpdateUser() {
        User user = TestUtils.createUser();
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.updateUser(user));
    }
}