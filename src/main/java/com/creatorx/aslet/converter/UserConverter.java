package com.creatorx.aslet.converter;

import com.creatorx.aslet.dto.UserCreateDto;
import com.creatorx.aslet.dto.UserDto;
import com.creatorx.aslet.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserConverter {
    public UserDto userToDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getUsername(), user.getRole());
    }

    public List<UserDto> userToDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: users) {
            userDtos.add(new UserDto(user.getId(), user.getName(), user.getEmail(), user.getUsername(), user.getRole()));
        }
        return userDtos;
    }

    public User userCreateDtoToUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setName(userCreateDto.getName());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());
        user.setUsername(userCreateDto.getUsername());
        user.setRole(userCreateDto.getRole());
        return user;
    }
}
