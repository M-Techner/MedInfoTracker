package com.medinfotracker.medinfotracker.controllers;


import com.medinfotracker.medinfotracker.models.Profile;
import com.medinfotracker.medinfotracker.models.User;
import com.medinfotracker.medinfotracker.models.data.ProfileRepository;
import com.medinfotracker.medinfotracker.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private ProfileRepository profileRepository;
//
//    private <EntUserId> EntUserId getUserId(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        EntUserId profile = (EntUserId) session.getAttribute("id");
//        return id;
//    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("Title", "User");
        model.addAttribute("User", userRepository.findAll());
        return "user/index";
    }

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User newUser,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
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
            model.addAttribute("title", "user: " + ((User) optUser.get()).getId());
            model.addAttribute("user", user);
            return "user/view";
        } else {
            return "redirect:../";
        }
    }

}
