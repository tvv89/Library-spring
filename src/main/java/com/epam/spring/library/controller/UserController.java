package com.epam.spring.library.controller;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.mapper.UserMapper;
import com.epam.spring.library.model.User;
import com.epam.spring.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Valid
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<UserDTO> getUsers() {
        log.debug("Show all users");
        return UserMapper.INSTANCE.mapListOfUsersDTO(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") long id) {
        log.debug("Show user by id " + id);
        return UserMapper.INSTANCE.mapUserDTO(userService.getUserById(id));
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        log.debug("Creat users by request " + userDTO);
        User user = UserMapper.INSTANCE.mapUser(userDTO);
        return UserMapper.INSTANCE.mapUserDTO(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public UserDTO deleteUser(@PathVariable("id") long id) {
        log.debug("Delete user by id " + id);
        User user = userService.getUserById(id);
        log.debug("This user will be deleted: " + user);
        return UserMapper.INSTANCE.mapUserDTO(userService.deleteUser(user));
    }

    @PutMapping()
    public UserDTO updateUser(@RequestBody @Valid UserDTO userDTO) {
        log.debug("Update user: " + userDTO);
        User user = userService.updateUser(UserMapper.INSTANCE.mapUser(userDTO));
        log.debug("This user was updated: " + user);
        return UserMapper.INSTANCE.mapUserDTO(user);

    }


}
