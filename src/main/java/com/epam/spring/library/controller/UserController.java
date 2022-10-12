package com.epam.spring.library.controller;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.mapper.UserMapper;
import com.epam.spring.library.model.User;
import com.epam.spring.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Valid
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<UserDTO> getUsers() {
        return UserMapper.INSTANCE.mapListOfUsersDTO(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") long id) {
        return UserMapper.INSTANCE.mapUserDTO(userService.getUserById(id));
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO)
    {
        User user = UserMapper.INSTANCE.mapUser(userDTO);
        return UserMapper.INSTANCE.mapUserDTO(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public UserDTO deleteUser(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        return UserMapper.INSTANCE.mapUserDTO(userService.deleteUser(user));
    }

    @PutMapping()
    public UserDTO updateUser(@RequestBody @Valid UserDTO userDTO) {
        User user = userService.updateUser(UserMapper.INSTANCE.mapUser(userDTO));
        return UserMapper.INSTANCE.mapUserDTO(user);

    }


}
