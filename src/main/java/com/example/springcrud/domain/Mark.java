package com.example.springcrud.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name= "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "mark")
    private int mrk;
    @Column(name = "CourseCode")
    private String code;
    @ManyToOne
    @JoinColumn(name = "Studentid")
    private Student student;

    public Mark() {
    }

    public Mark(int mrk) {
        this.mrk = mrk;

    }
    public Mark(String code) {
        this.code = code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMrk(int mrk) {
        this.mrk = mrk;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public int getMrk() {
        return mrk;
    }

    public String getCode() {
        return code;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
