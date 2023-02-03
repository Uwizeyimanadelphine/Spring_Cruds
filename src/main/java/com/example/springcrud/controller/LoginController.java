package com.example.springcrud.controller;

import ch.qos.logback.core.model.Model;
import com.example.springcrud.domain.LoginForm;
import com.example.springcrud.domain.Student;
import com.example.springcrud.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    private LoginService userService;


    @GetMapping("/")

    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("student", new Student());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("student") Student student ) {

        Student oauthUser = userService.login(student.getUsername(), student.getPassword());


        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {

            return "redirect:/students";


        } else {
            return "redirect:/";


        }

    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {


        return "redirect:/";
    }
}
