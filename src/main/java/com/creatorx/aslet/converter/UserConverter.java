package com.creatorx.aslet.converter;

import com.creatorx.aslet.dto.UserCreateDto;
import com.creatorx.aslet.dto.UserDto;
import com.creatorx.aslet.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {
    public static UserDto userToDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getUsername(), user.getRole());
    }

    public static List<UserDto> userToDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: users) {
            userDtos.add(new UserDto(user.getId(), user.getName(), user.getEmail(), user.getUsername(), user.getRole()));
        }
        return userDtos;
    }

    public static User userCreateDtoToUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setName(userCreateDto.getName());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());
        user.setUsername(userCreateDto.getUsername());
        user.setRole(userCreateDto.getRole());
        return user;
    }
}
