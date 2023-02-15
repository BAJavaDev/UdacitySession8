package com.udacity.session.demosix.services;

import com.udacity.session.demosix.mappers.UserMapper;
import com.udacity.session.demosix.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public int createUser(User user) {
        return userMapper.insert(new User(null, user.getUsername(), user.getSalt(), user.getPassword(), user.getFirstname(), user.getLastname()));
    }

    public boolean isUsernameAvailable(String username) {
        return userMapper.getUser(username) == null;
    }

}
