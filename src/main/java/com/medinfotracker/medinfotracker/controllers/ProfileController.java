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
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;

////    private HandshakeCompletedEvent request;
//    HttpSession session = request.getSession();
//    int id = session.getAttribute("id");


//    String userName = (String) session.getAttribute("userName");

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("Title", "User Profile");
        model.addAttribute("User Profile", profileRepository.findAll());
        return "index";
    }

    @GetMapping("add")
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
        return "profile/add";
    }

    @PostMapping("add")
    public String processAddProfileForm(@ModelAttribute @Valid Profile newProfile,
                                        Errors errors, Model model, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User Profile Details");
            return "profile/add";
        }

        User user = authenticationController.getUserFromSession(request.getSession());

        user.setProfile(newProfile);
        profileRepository.save(newProfile);
        userRepository.save(user);
//        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("profile", profileRepository.findAll());
        return "redirect:";
    }

    @GetMapping("view/{id}")
    public String displayViewProfile(Model model, @PathVariable int id) {
        model.addAttribute("profile", profileRepository.findAll());

        Optional optProfile = profileRepository.findById(id);
        if (optProfile.isPresent()) {
            Profile profile = (Profile) optProfile.get();
            model.addAttribute("title", "User Profile: " + ((Profile) optProfile.get()).getId());
            model.addAttribute("profile", profile);
            return "profile/view";
        } else {
            return "redirect:..";
        }

    }
}
