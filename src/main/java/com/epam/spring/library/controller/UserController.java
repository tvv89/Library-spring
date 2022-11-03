package com.epam.spring.library.controller;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.mapper.UserMapper;
import com.epam.spring.library.model.User;
import com.epam.spring.library.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Api(value = "UserController", tags = "REST APIs for user entity")
public class UserController {

    private final UserService userService;


    @GetMapping()
    @ApiOperation(value = "Get list of users in the system", response = List.class)
    public List<UserDTO> getUsers() {
        log.info("Show all users");
        return UserMapper.INSTANCE.mapListOfUsersDTO(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get user by id from the system", response = UserDTO.class)
    public UserDTO getUserById(@PathVariable("id") long id) {
        log.info("Show user by id " + id);
        User user = userService.getUserById(id);
        if (user==null) throw new EntityNotFoundException("user not found");
        return UserMapper.INSTANCE.mapUserDTO(user);
    }

    @PostMapping()
    @ApiOperation(value = "Create users in the system", response = UserDTO.class)
    public UserDTO createUser(@RequestBody @Valid UserDTO userDTO){
        log.info("Creat users by request " + userDTO);
        User user = UserMapper.INSTANCE.mapUser(userDTO);
        return UserMapper.INSTANCE.mapUserDTO(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete user by id in the system", response = UserDTO.class)
    public UserDTO deleteUser(@PathVariable("id") long id) {
        log.info("Delete user by id " + id);
        User user = userService.getUserById(id);
        if (user==null) throw new EntityNotFoundException("user not found");
        userService.deleteUser(user);
        log.info("This user will be deleted: " + user);
        return UserMapper.INSTANCE.mapUserDTO(user);
    }

    @PutMapping()
    @ApiOperation(value = "Update user by id in the system", response = UserDTO.class)
    public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO) {
        log.info("Update user: " + userDTO);
        User user = userService.updateUser(UserMapper.INSTANCE.mapUser(userDTO));
        log.debug("This user was updated: " + user);
        return UserMapper.INSTANCE.mapUserDTO(user);
    }


}
