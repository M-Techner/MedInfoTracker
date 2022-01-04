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

//    @Autowired
//    private SymptomRepository symptomRepository;
//
//    @Autowired
//    private MedicationRepository medicationRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "My Profile");
        model.addAttribute("profile", profileRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddProfileForm(Model model) {
        model.addAttribute("title", "Add Profile");
//        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("profile", profileRepository.findAll());
        model.addAttribute(new Profile());
        return "add";
    }


    @PostMapping("add")
    public String processAddProfileForm(@ModelAttribute @Valid User newUser,
                                        Errors errors, Model model, @RequestParam int userId) {
//                                    @RequestParam List<Integer> symptoms

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Profile");
            return "add";
        }

//        User newUser = userRepository.findById(userId).orElse(new User());
        Profile newProfile = profileRepository.findById(userId).orElse(new Profile());

//        Profile newProfile = profileRepository.findById(userId).orElse(new Profile());
//        newProfile.setUser(newProfile);
////        List<Symptom> symptomObj = (List<Symptom>) symptomRepository.findAllById(symptoms);
////        newProfile.setSymptoms(symptomObj);
//        model.addAttribute("profile", profileRepository.findAll());

        profileRepository.save(newProfile);
        return "redirect:";
    }

//        User newUser = userRepository.findById(userId).orElse(new User());
//        newSymptom.setUser(newUser);
//        List<Symptom> symptomObj = (List<Symptom>) symptomRepository.findAllByID(symptoms);

//        return "redirect:";
//    }


    @GetMapping("view/{userId}")
    public String displayViewUser(Model model, @PathVariable int userId) {

        Optional optUser = profileRepository.findById(userId);
        if (!optUser.isEmpty()) {
            User user = (User) optUser.get();
            model.addAttribute("user", user);
            return "view";
        } else {
            return "redirect:/";
        }

//            model.addAttribute("user", userRepository.findAll());
//            if (userId == 0) {
//                model.addAttribute("user", userRepository.findAll());
//            } else
//            {
//                Optional<User> optUser;
//                optUser = userRepository.findById(userId);
//
//                if (optUser.isPresent()) {
//                    model.addAttribute("title", "Job: " + optUser.get().getUserName());
//                }
//                model.addAttribute("job", optUser.get());
//                return "view";
//            }
//            return "redirect:/";
//        }
    }
}
