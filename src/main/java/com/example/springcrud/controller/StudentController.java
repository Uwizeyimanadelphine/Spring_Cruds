package com.example.springcrud.controller;

import com.example.springcrud.repository.StudentRepository;
import org.springframework.ui.Model;
import com.example.springcrud.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository repo;

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> listStudents = repo.findAll();
        model.addAttribute("listStudents", listStudents);
        return "students";
    }

    @GetMapping("/students/new")
    public String showNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "st_new";
    }

    @PostMapping("/students/save")
    public String saveStudent(Student student) {
        repo.save(student);
        return "redirect:/students";
    }
    @GetMapping("students/edit/{reg_no}")
    public String showEditStudent(@PathVariable(name = "reg_no") Long reg_no, Model model) {

        Student student = repo.findById(reg_no).get();
        model.addAttribute("student", student);
       // List<Student> listStudents = repo.findAll();
       // model.addAttribute("listStudents", listStudents);
        return "st_new";
    }


    @GetMapping("students/delete/{reg_no}")
    public String deleteStudent(@PathVariable(name = "id") Long reg_no, Model model) {
        repo.deleteById(reg_no);
        return "redirect:/students";
    }
}
