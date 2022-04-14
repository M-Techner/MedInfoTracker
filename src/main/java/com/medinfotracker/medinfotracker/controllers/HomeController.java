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
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AuthenticationController authenticationController;

//    CHECK INTO THIS @INITBINDER INFO = PAY ATTENTION

//    @InitBinder
//    void initAllowFields(WebDataBinder binder) {
////        binder.setAllowedFields("userPreferredName");
//        binder.setAllowedFields("userMedicalRecordName");
//        binder.setAllowedFields("userAddress");
//        binder.setAllowedFields("userPhoneNumber");
//        binder.setAllowedFields("userDateOfBirth");
////        binder.setAllowedFields("userPreferredPronouns");
//        binder.setAllowedFields("emergencyName");
//        binder.setAllowedFields("emergencyPhoneNumber");
//        binder.setAllowedFields("emergencyRelationship");
//        binder.setAllowedFields("primaryCarePhysicianName");
//        binder.setAllowedFields("primaryCarePhysicianAddress");
//        binder.setAllowedFields("primaryCarePhysicianPhoneNumber");
//        binder.setAllowedFields("specialistName");
//        binder.setAllowedFields("specialistPhoneNumber");
//        binder.setAllowedFields("specialistType");
//        binder.setAllowedFields("allergies");
//        binder.setAllowedFields("medicalConditions");
//        binder.setAllowedFields("userName");
//        binder.setAllowedFields("userId");
////        binder.setAllowedFields("name");
//    }


    @RequestMapping("index")
    public String index(Model model, HttpServletRequest request, RegisterFormDTO registerFormDTO ) {
//        model.addAttribute("title", "User");
//        model.addAttribute("user", userRepository.findAll());
//        model.addAttribute("userName", loginFormDTO.getUserName());
//        model.addAttribute("profile", profileRepository.findAll());

//        @GetMapping("")
//        public String sessionUser(@SessionAttribute("user") User sessionUser, Model model)

        User user = authenticationController.getUserFromSession(request.getSession());
        model.addAttribute("user", user);
        model.addAttribute("name", user.getUserName());
        model.addAttribute("userId", user.getUserId());
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
//
//    @GetMapping("")
//    public String sessionUser(@SessionAttribute("user") User sessionUser, final Model model) {
//        model.addAttribute("user",sessionUser);
//        return "sessionUser";
//    }



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
//        newUser.getUserId(newProfile);
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

