package com.medinfotracker.medinfotracker.controllers;


import com.medinfotracker.medinfotracker.models.User;
import com.medinfotracker.medinfotracker.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("Title", "User Profile");
        model.addAttribute("User Profile", userRepository.findAll());
        return "user/index";
    }

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("Emergency Contact Name", "Add Emergency Contact Name");
        model.addAttribute("Emergency Contact Phone Number", "Add Emergency Contact Phone Number");
        model.addAttribute("Emergency Contact Relationship", "Add Emergency Contact Relationship");
        model.addAttribute("Primary Care Physician Name", "Add Primary Care Physician Name");
        model.addAttribute("Primary Care Physician Address", "Add Primary Care Physician Address");
        model.addAttribute("Primary Care Physician Phone Number", "Add Primary Care Physician Phone Number");
        model.addAttribute("Specialist Name", "Add Specialist Name");
        model.addAttribute("Specialist Phone Number", "Add Specialist Phone Number");
        model.addAttribute("Specialist Type", "Add Specialist Type");
        model.addAttribute("Known Allergies", "Add Known Allergies");
        model.addAttribute("Medical Conditions", "Add Medical Conditions");
        model.addAttribute(new User());
        return "user/add";

    }

    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User newUser,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User Details");
            return "user/add";
        }

        userRepository.save(newUser);
        model.addAttribute("user", userRepository.findAll());
        return "redirect:";
    }

    @GetMapping("view/{userId}")
    public String displayViewUser(Model model, @PathVariable int userId) {
        model.addAttribute("user", userRepository.findAll());

        Optional optUser = userRepository.findById(userId);
        if (optUser.isPresent()) {
            User user = (User) optUser.get();
            model.addAttribute("title", "user: " + ((User) optUser.get()).getUserId());
            model.addAttribute("user", user);
            return "user/view";
        } else {
            return "redirect:../";
        }
    }

}
