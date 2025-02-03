package com.win.userservice.mapper;


import com.win.userservice.dto.UserDTO;
import com.win.userservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Allows for dependency injection
public interface UserMapper {

    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);
}
