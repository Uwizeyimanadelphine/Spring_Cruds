package com.example.springcrud.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Data
@ToString

@Entity
@Table(name= "student")
public class Student {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "reg_no")
    private Long reg_no;
    private String name;
    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;
    public Student() {

    }

    public Student(Long reg_no, String name) {
        this.reg_no = reg_no;
        this.name = name;


    }

    public Long getReg_no() {
        return reg_no;
    }

    public void setReg_no(Long reg_no) {
        this.reg_no = reg_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}