package com.medinfotracker.medinfotracker.controllers;


import com.medinfotracker.medinfotracker.Models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public void index(Model model) {


    }
}
