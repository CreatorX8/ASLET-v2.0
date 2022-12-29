package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.UserConverter;
import com.creatorx.aslet.dto.*;
import com.creatorx.aslet.exception.NotAuthorizedException;
import com.creatorx.aslet.exception.UserExistsException;
import com.creatorx.aslet.exception.UserNotApprovedException;
import com.creatorx.aslet.exception.UserNotFoundException;
import com.creatorx.aslet.model.User;
import com.creatorx.aslet.repository.UserRepository;
import com.creatorx.aslet.utils.AccessUtils;
import com.creatorx.aslet.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AccessUtils accessUtils;

    public UserDto createUser(UserCreateDto userCreateDto) {
        if (userRepository.findByEmail(userCreateDto.getEmail()).size() > 0) throw new UserExistsException();
        User newUser = userConverter.userCreateDtoToUser(userCreateDto);
        userRepository.save(newUser);
        return userConverter.userToDto(newUser);
    }

    public UserLoggedDto loginUser(UserLoginDto userLoginDto) {
        User user = userRepository.findByEmailIgnoreCaseAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
        if (user == null) throw new UserNotFoundException();
        if (!user.getApproved()) throw new UserNotApprovedException();
        return userConverter.userToUserLoggedDto(user, jwtUtils.generateToken(user));
    }

    public List<UserDto> getAllUsers() {
        if (!accessUtils.isAdmin()) throw new NotAuthorizedException();
        return userConverter.userToDto(userRepository.findAll());
    }

    public UserDto getUserById(Long id) {
        if (!accessUtils.isAdmin()) throw new NotAuthorizedException();
        return userConverter.userToDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    public User getUserByIdDefault(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public UserDto updateUser(UserDto updatedUser, Long id) {
        if (!accessUtils.isAdmin()) throw new NotAuthorizedException();
        if (userRepository.findByEmail(updatedUser.getEmail()).size() > 0) throw new UserExistsException();
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
        if (!accessUtils.isAdmin()) throw new NotAuthorizedException();
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}
