package com.example.springcrud.repository;

import com.example.springcrud.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Student, Long> {

        Student findByUsernameAndPassword(String username, String password);

}
