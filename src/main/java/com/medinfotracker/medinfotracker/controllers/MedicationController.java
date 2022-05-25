package com.medinfotracker.medinfotracker.controllers;


import com.medinfotracker.medinfotracker.models.Medication;
import com.medinfotracker.medinfotracker.models.User;
import com.medinfotracker.medinfotracker.models.data.MedicationRepository;
import com.medinfotracker.medinfotracker.models.data.UserRepository;
import com.medinfotracker.medinfotracker.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("medication")
public class MedicationController {
    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;


    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("Title", "User");
        model.addAttribute("User", userRepository.findAll());
        return "index";
    }

    @GetMapping(value = "add")
    public String displayAddMedicationForm(Model model) {


        model.addAttribute("Medication Name", "add Medication Name");
        model.addAttribute("Date Started", "add Date Started");
        model.addAttribute("Prescribing Physician", "add Prescribing Physician");
        model.addAttribute("Dosage", "add Dosage");
        model.addAttribute("Frequency", "add Frequency");
        model.addAttribute("Route Of Administration", "add Route Of Administration");
        model.addAttribute("Refill", "add Refill");
        model.addAttribute("Over the Counter", "add Over the Counter");
        model.addAttribute(new Medication());
        return "medication/add";
    }

    @PostMapping(value = "add")
    public String processAddMedicationForm(@ModelAttribute @Valid Medication newMedication, Errors errors, Model model, HttpServletRequest request) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Medication Information");
            return "/medication/add";
        }

        User user = authenticationController.getUserFromSession(request.getSession());
        user.addMedication(newMedication);
//        medicationRepository.save(newMedication);
        medicationRepository.save(newMedication);
        userRepository.save(user);
        model.addAttribute("medication", medicationRepository.findAll());
        return "redirect:";
    }

    @GetMapping("MedicationView/{userId}")
    public String displayViewMedication (Model model, HttpServletRequest request) {
//        model.addAttribute("user", userRepository.findById(profile_id));

        User existingUser = authenticationController.getUserFromSession(request.getSession());

        model.addAttribute("user", existingUser);
        model.addAttribute("userId", existingUser.getUserId());
        //model.addAttribute("profile", existingUser.getProfile());
        model.addAttribute("Medication",existingUser.getMedications());
        return "medication/medicationView";   }


//    @GetMapping("MedicationView/{userId}")
//    public String displayViewMedication (@ModelAttribute @Valid Medication viewMedication,
//                                         String userName, @PathVariable("userId") int userId, Errors errors, Model model, HttpServletRequest request) {
////        model.addAttribute("medication", medicationRepository.findAll());
//         User existingUser= authenticationController.getUserFromSession(request.getSession());
//
//        existingUser = userRepository.findByUserName(userName);
//        if (existingUser != null) {
//            errors.rejectValue("userName", "userName.alreadyExists", "That username is already in use.");
//            model.addAttribute("title", "Register");
//            return "medication/MedicationView";
//        }
//        Optional optUser = userRepository.findById(userId);
//        if (optUser.isPresent()) {
//            User user = (User) optUser.get();
//            model.addAttribute("title", "user: " + ((User) optUser.get()).getUserId());
//            model.addAttribute("user", user);
//            return "medication/medicationView";
//        } else {
//            return "redirect:./";
//        }
//    }







//    @GetMapping("medicationView/{userId}")
//    public String displayViewMedication(Model model, RegisterFormDTO registerFormDTO, Errors errors, String userName,
//                                         @PathVariable("userId") int userId, HttpServletRequest request) {
////        model.addAttribute("user", userRepository.findById(profile_id));
//
//        User existingUser = authenticationController.getUserFromSession(request.getSession());
//
//        User existingUser = userRepository.findByUserName(userName);
//        if (existingUser != null) {
//            errors.rejectValue("userName", "userName.alreadyExists", "That username is already in use.");
//            model.addAttribute("title", "Register");
//            return "medication/medicationView";
//        }
//        Optional optUser = userRepository.findById(userId);
//        if (optUser.isPresent()) {
//            User user = (User) optUser.get();
//            model.addAttribute("title", "user: " + ((User) optUser.get()).getUserId());
//            model.addAttribute("user", user);
//            return "medication/medicationView";
//        } else {
//            return "redirect:./";
//        }
//    }

    @PostMapping("medicationView/{userId}")
    public String deleteMedication( @ModelAttribute User user, Model model, HttpServletRequest request) {

       user = authenticationController.getUserFromSession(request.getSession());

        List<Medication> medication = user.getMedications();
        user.deleteMedication(medication);
        medicationRepository.delete((Medication) medication);
        userRepository.save(user);


        return "";
    }







//        Optional optMedication = medicationRepository.findById(userId);
//        if (optMedication.isPresent()) {
//            Medication medication = (Medication) optMedication.get();
//            model.addAttribute("medication", medication);
//            return "medication/MedicationView";
//        } else {
//            return "redirect:..";


//            @GetMapping("profileView/{userId}")
//            public String displayViewUserProfile(Model model, RegisterFormDTO registerFormDTO, Errors errors,
//            @PathVariable("userId") int userId) {
////        model.addAttribute("user", userRepository.findById(profile_id));
//
//                User existingUser = userRepository.findByUserName(registerFormDTO.getUserName());
//                if (existingUser != null) {
//                    errors.rejectValue("userName", "userName.alreadyExists", "That username is already in use.");
//                    model.addAttribute("title", "Register");
//                    return "user/profileView";
//                }
//                Optional optUser = userRepository.findById(userId);
//                if (optUser.isPresent()) {
//                    User user = (User) optUser.get();
//                    model.addAttribute("title", "user: " + ((User) optUser.get()).getUserId());
//                    model.addAttribute("user", user);
//                    return "user/profileView";
//                } else {
//                    return "redirect:/";
//                }
//            }
        }







//package com.medinfotracker.medinfotracker.controllers;
//
//import com.medinfotracker.medinfotracker.models.Medication;
//import com.medinfotracker.medinfotracker.models.data.MedicationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("medication")
//public class MedicationController {
//    @Autowired
//    private MedicationRepository medicationRepository;
//
//    @GetMapping(value = "addMed")
//    public String displayAddMedicationForm(Model model) {
//
//
//        model.addAttribute("Medication Name","add Medication Name");
//        model.addAttribute("Date Started","add Date Started");
//        model.addAttribute("Prescribing Physician", "add Prescribing Physician");
//        model.addAttribute("Dosage", "add Dosage");
//        model.addAttribute("Frequency", "add Frequency");
//        model.addAttribute("Route Of Administration", "add Route Of Administration");
//        model.addAttribute("Refill", "add Refill");
//        model.addAttribute("Over the Counter", "add Over the Counter");
//        model.addAttribute(new Medication());
//        return "/medication/addMed";
//    }
//
//    @PostMapping(value = "addMed")
//    public String processAddMedicationForm(@ModelAttribute @Valid Medication newMedication, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Medication Information");
//            return "/medication/addMed";
//        }
//
//        medicationRepository.save(newMedication);
//        model.addAttribute("medication", medicationRepository.findAll());
//        return "redirect:..";
//
//    }
//    @GetMapping("view/{userId}")
//    public String displayViewMedication(Model model, @PathVariable int userId) {
//        model.addAttribute("medication", medicationRepository.findAll());
//        Optional optMedication = medicationRepository.findById(userId);
//        if (optMedication.isPresent()) {
//            Medication medication = (Medication) optMedication.get();
//            model.addAttribute("medication", medication);
//            return "/medication/view";
//        } else {
//            return "redirect:..";
//        }
//
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
