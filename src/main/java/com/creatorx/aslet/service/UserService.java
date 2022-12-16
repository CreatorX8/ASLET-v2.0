package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.UserConverter;
import com.creatorx.aslet.dto.UserCreateDto;
import com.creatorx.aslet.dto.UserDto;
import com.creatorx.aslet.exception.UserExistsException;
import com.creatorx.aslet.exception.UserNotFoundException;
import com.creatorx.aslet.model.User;
import com.creatorx.aslet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    public UserDto createUser(UserCreateDto userCreateDto) {
        if (userRepository.findByEmail(userCreateDto.getEmail()).size() > 0) throw new UserExistsException();
        User newUser = userConverter.userCreateDtoToUser(userCreateDto);
        userRepository.save(newUser);
        return userConverter.userToDto(newUser);
    }

    public List<UserDto> getAllUsers() {
        return userConverter.userToDto(userRepository.findAll());
    }

    public UserDto getUserById(Long id) {
        return userConverter.userToDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    public UserDto updateUser(UserDto updatedUser, Long id) {
        return userConverter.userToDto(
                userRepository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    user.setUsername(updatedUser.getUsername());
                    user.setRole(updatedUser.getRole());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id)));
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}
