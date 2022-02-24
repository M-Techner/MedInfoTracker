package com.medinfotracker.medinfotracker.controllers;


import com.medinfotracker.medinfotracker.models.Profile;
import com.medinfotracker.medinfotracker.models.User;
import com.medinfotracker.medinfotracker.models.data.ProfileRepository;
import com.medinfotracker.medinfotracker.models.data.UserRepository;
import com.medinfotracker.medinfotracker.models.dto.LoginFormDTO;
import com.medinfotracker.medinfotracker.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AuthenticationController authenticationController;

//    CHECK INTO THIS @INITBINDER INFO = PAY ATTENTION

    @InitBinder
    void allowFields(WebDataBinder webDataBinder) {
        webDataBinder.setAllowedFields("userName");
//        webDataBinder.setAllowedFields("symptoms");
//        webDataBinder.setAllowedFields("symptomNotes");
//        webDataBinder.setAllowedFields("medication");
        webDataBinder.setAllowedFields("profile");
    }

//    private static final String userSessionKey = "user";

//    public User getUserFromSession(@NotNull HttpSession session) {
//        Integer session_id = (Integer) session.getAttribute(userSessionKey);
//        if (session_id == null) {
//            return null;
//        }
//
//        Optional<User> user = userRepository.findById(session_id);
//
//        if (user.isEmpty()) {
//            return null;
//        }
//
//        return user.get();
//    }

//    private static void setUserInSession(HttpSession session, User user) {
//        session.setAttribute(userSessionKey, user.getId());
//    }


    @RequestMapping("")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("title", "User");
        model.addAttribute("user", userRepository.findAll());
//        model.addAttribute("userName", loginFormDTO.getUserName());
        model.addAttribute("profile", profileRepository.findAll());

                User user = authenticationController.getUserFromSession(request.getSession());
//        setUserInSession(session, user);


//
//        User existingUser = userRepository.findByUserName(registerFormDTO.getUserName());
//        if (existingUser != null) {
////            errors.rejectValue("userName", "userName.alreadyexists", "That username is already in use.");
////            model.addAttribute("title", "Register");
//            return "user/profileView";
//        }

        return "index";
    }
//
//    @RequestMapping("")
//    public String index(@ModelAttribute  Errors errors, Model model, @RequestParam Profile profile) {
////                                    @RequestParam
//
//        User user = authenticationController.getUserFromSession(request.getSession());
//
//
//        return "redirect:";
//    })


//    @PostMapping("add")
//    public String processAddProfileForm(@ModelAttribute @Valid Profile newProfile,
//                                        Errors errors, Model model, @RequestParam int userId) {
////                                    @RequestParam
//
//        if (errors.hasErrors()) {
////            model.addAttribute("title", "Add Profile");
//            return "add";
//        }

//        User newUser = userRepository.findById(userId).orElse(new User());
//
////        newProfile = profileRepository.findById(userId).orElse(new Profile());
//        newUser.getuserId(newProfile);
////        List<Symptom> symptomObj = (List<Symptom>) symptomRepository.findAllById(symptoms);
////        newProfile.setSymptoms(symptomObj);
//        model.addAttribute("profile", profileRepository.findAll());
//
//        profileRepository.save(newProfile);
//        return "redirect:";
//    }

//        User newUser = userRepository.findById(userId).orElse(new User());
//        newSymptom.setUser(newUser);
//        List<Symptom> symptomObj = (List<Symptom>) symptomRepository.findAllByID(symptoms);

//        return "redirect:";
//    }


//    @GetMapping("view/{id}")
//    public String displayViewUserProfile(Model model, @PathVariable int id) {
//
//        Optional optUser = userRepository.findById(id);
//        if (!optUser.isEmpty()) {
//            Profile profile = (Profile) optUser.get();
//            model.addAttribute("user", optUser.get());
//            return "user/view/";
//        } else {
//            return "redirect:/";
//        }

//            model.addAttribute("userId", userRepository.findAll());
//            if (userId == 0) {
//                model.addAttribute("userId", userRepository.findAll());
//            } else
//            {
////                Optional<User> optUser;
////                Optional optUser = userRepository.findById(userId);
//
//                if (optProfile.isPresent()) {
//                    model.addAttribute("title", "User: " + optProfile.get()
////                            .getUserLegalName()
//                    );
//                }
//                model.addAttribute("job", optProfile.get());
//                return "view";
//            }
//             return "redirect:/";
//        }
    }

