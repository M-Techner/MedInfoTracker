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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AuthenticationController authenticationController;

//    @Autowired
//    private SymptomRepository symptomRepository;
//
//    @Autowired
//    private MedicationRepository medicationRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "User");
        model.addAttribute("username", userRepository.findAll());
        return "index";
    }
//    NEED TO CREATE REDIRECT URL WITH CREDENTIALS FILE< THAT PASSES ALL THE  NECESSARY INFO - LOOK  THIS UP



//    @GetMapping("add")
//    public String displayAddProfileForm(Model model) {
//        model.addAttribute("title", "Add Profile");
//        model.addAttribute("user", userRepository.findAll());
//        model.addAttribute("profile", profileRepository.findAll());
//        model.addAttribute(new Profile());
//        return "add";
//    }


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

