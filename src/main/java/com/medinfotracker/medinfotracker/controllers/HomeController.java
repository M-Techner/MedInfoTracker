package com.medinfotracker.medinfotracker.controllers;


import com.medinfotracker.medinfotracker.models.User;
import com.medinfotracker.medinfotracker.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "Users");
        model.addAttribute("user", userRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute("employers", userRepository.findAll());
//        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute(new User());
        return "add";
    }


    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User newUser,
                                    Errors errors, Model model, @RequestParam int userId) {
//                                    @RequestParam List<Integer> symptoms

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            return "add";
        }

//        User newUser = userRepository.findById(userId).orElse(new User());
//        newSymptom.setUser(newUser);
//        List<Symptom> symptomObj = (List<Symptom>) symptomRepository.findAllByID(symptoms);

        return "redirect:";
    }


        @GetMapping("view/{userId}")
        public String displayViewUser (Model model,@PathVariable int userId){
            model.addAttribute("job", userRepository.findAll());
            if (userId == 0) {
                model.addAttribute("job", userRepository.findAll());
            } else {
                Optional<User> optUser;
                optUser = userRepository.findById(userId);

                if (optUser.isPresent()) {
                    model.addAttribute("title", "Job: " + optUser.get().getUserName());
                }
                model.addAttribute("job", optUser.get());
                return "view";
            }
            return "redirect:/";
        }
    }
