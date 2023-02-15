package com.udacity.session.demosix.security;

import com.udacity.session.demosix.mappers.UserMapper;
import com.udacity.session.demosix.model.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService implements AuthenticationProvider {
    private UserMapper userMapper;
    public AuthenticationService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("authenticating");
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userMapper.getUser(username);
        if (user != null) {
            System.out.println("user password: " + user.getPassword());
            System.out.println("entered password: " + password);
            if (user.getPassword().equals(password)){
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
