package com.example.springcrud.controller;

import com.example.springcrud.domain.Mark;
import com.example.springcrud.domain.Student;
import com.example.springcrud.repository.MarkRepository;
import com.example.springcrud.repository.StudentRepository;
import com.example.springcrud.service.MarkService;
import com.example.springcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class MarkController {
    @Autowired
    private MarkRepository markRepo;
    @Autowired
    private StudentRepository studentRepo;

    /*@GetMapping("/marks/new")
    public String viewMarkPage(Model model) {
        List<Mark> listMarks = repo.findAll();
        model.addAttribute("listMarks", listMarks);
        return "marks";
    }*/

    @GetMapping("/marks/new")
    public String showNewMark(Model model) {
        List<Student> listStudents = studentRepo.findAll();
        model.addAttribute("mark", new Mark());
        model.addAttribute("listStudents", listStudents);

        return "mrk_new";
    }
    @PostMapping("/marks/save")
    public String saveMark(Mark mark){
        markRepo.save(mark);
        return "redirect:/marks";
    }

    @GetMapping("/marks")
    public String listMarks(Model model) {
        List<Mark> listMarks = markRepo.findAll();
        model.addAttribute("listMarks", listMarks);
        return "marks";
     }

    @GetMapping("marks/edit/{id}")
    public String showEditMark(@PathVariable(name = "id") int id, Model model) {

        Mark mark = markRepo.findById(id).get();
        model.addAttribute("mark", mark);
        List<Student> listStudents = studentRepo.findAll();
        model.addAttribute("listStudents", listStudents);
        return "mrk_new";
    }

    @GetMapping("marks/delete/{id}")
    public String deleteMark(@PathVariable(name = "id") int id, Model model) {
        markRepo.deleteById(id);
        return "redirect:/marks";
    }

}
