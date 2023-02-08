package com.example.springcrud.Dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository

public class UserDAo {
    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "test1@gmail.com",
                    "test1",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),

            new User(
                    "user@gmail.com",
                    "user",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );
    public UserDetails findUserByEmail(String email) {
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user found"))
                ;    }
}
