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

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("Title", "User");
        model.addAttribute("User", userRepository.findAll());
//        model.addAttribute("profile", profileRepository.findAll());
        return "index";
    }

    @GetMapping("addProfile")
    public String displayAddProfileForm(Model model) {
//        model.addAttribute("Username", "${user.userName}");
        model.addAttribute("User Medical Record Name", "Add User Medical Record Name");
        model.addAttribute("User Address", "Add User Address");
        model.addAttribute("User Phone Number", "Add User Phone Number");
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
        model.addAttribute(new Profile());
        return "user/addProfile";
    }

    @PostMapping("addProfile")
    public String processAddProfileForm(@ModelAttribute @Valid Profile newProfile,
                                        Errors errors, Model model, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User Profile Details");
            return "user/addProfile";
        }

        User user = authenticationController.getUserFromSession(request.getSession());

        user.setProfile(newProfile);
        profileRepository.save(newProfile);
        userRepository.save(user);
//        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("profile", profileRepository.findAll());
        return "redirect:";
    }


//    @GetMapping("add")
//    public String displayAddUserForm(Model model) {
//        model.addAttribute("title", "Add User");
//        model.addAttribute(new User());
//        return "user/add";
//    }

//    @PostMapping("add")
//    public String processAddUserForm(@ModelAttribute @Valid User newUser,
//                                         Errors errors, Model model) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add User");
//            return "user/add";
//        }
//
//        userRepository.save(newUser);
//        model.addAttribute("user", userRepository.findAll());
//        return "redirect:";
//    }


//    Should this connect to the user session??
    @GetMapping("profileView/{id}")
    public String displayViewUser(Model model, @PathVariable("id") int id) {
//        model.addAttribute("user", userRepository.findAll());

        Optional optUser = userRepository.findById(id);
        if (optUser.isPresent()) {
            User user = (User) optUser.get();
            model.addAttribute("title", "user: " + ((User) optUser.get()).getId());
            model.addAttribute("user", user);
            return "user/profileView";
        } else {
            return "redirect:";
        }
    }

}
