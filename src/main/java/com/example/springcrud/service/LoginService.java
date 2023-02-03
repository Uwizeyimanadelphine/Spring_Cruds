package com.example.springcrud.service;

import com.example.springcrud.domain.Student;
import com.example.springcrud.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository repo;


    public Student login(String username, String password) {
        Student student = repo.findByUsernameAndPassword(username, password);
        return student;
    }
}
