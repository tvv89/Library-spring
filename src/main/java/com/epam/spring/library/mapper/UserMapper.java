package com.epam.spring.library.mapper;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDTO> mapListOfUsersDTO(List<User> users);

    List<User> mapListOfUsers(List<UserDTO> usersDTO);

    UserDTO mapUserDTO (User user);

    User mapUser(UserDTO userDTO);

}
