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




//    @GetMapping("add")
//    public String displayAddProfileForm(Model model) {
//        model.addAttribute("Username", "${user.userName}");
//        model.addAttribute("User Medical Record Name", "Add User Medical Record Name");
//        model.addAttribute("User Address", "Add User Address");
//        model.addAttribute("User Phone Number", "Add User Phone Number");
//        model.addAttribute("Emergency Contact Name", "Add Emergency Contact Name");
//        model.addAttribute("Emergency Contact Phone Number", "Add Emergency Contact Phone Number");
//        model.addAttribute("Emergency Contact Relationship", "Add Emergency Contact Relationship");
//        model.addAttribute("Primary Care Physician Name", "Add Primary Care Physician Name");
//        model.addAttribute("Primary Care Physician Address", "Add Primary Care Physician Address");
//        model.addAttribute("Primary Care Physician Phone Number", "Add Primary Care Physician Phone Number");
//        model.addAttribute("Specialist Name", "Add Specialist Name");
//        model.addAttribute("Specialist Phone Number", "Add Specialist Phone Number");
//        model.addAttribute("Specialist Type", "Add Specialist Type");
//        model.addAttribute("Known Allergies", "Add Known Allergies");
//        model.addAttribute("Medical Conditions", "Add Medical Conditions");
//        model.addAttribute(new Profile());
//        return "profile/add";
//    }

//    @PostMapping("add")
//    public String processAddProfileForm(@ModelAttribute @Valid Profile newProfile,
//                                        Errors errors, Model model, HttpServletRequest request) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add User Profile Details");
//            return "profile/add";
//        }
//
//        User user = authenticationController.getUserFromSession(request.getSession());
//
//        user.setProfile(newProfile);
//        profileRepository.save(newProfile);
//        userRepository.save(user);
////        model.addAttribute("user", userRepository.findAll());
//        model.addAttribute("profile", profileRepository.findAll());
//        return "redirect:";
//    }

//    @GetMapping("view/{id}")
//    public String displayViewProfile(Model model, @PathVariable int id) {
//        model.addAttribute("profile", profileRepository.findAll());
//
//        Optional optProfile = profileRepository.findById(id);
//        if (optProfile.isPresent()) {
//            Profile profile = (Profile) optProfile.get();
//            model.addAttribute("title", "User Profile: " + ((Profile) optProfile.get()).getId());
//            model.addAttribute("profile", profile);
//            return "profile/view";
//        } else {
//            return "redirect:..";
//        }



//    @RequestMapping(value = "deleteProfile/{userId}", method = {RequestMethod.POST, RequestMethod.GET})
//    public String deleteProfile(@ModelAttribute("profile") Profile profile,
//                                @RequestParam(required = false)
//                                @ModelAttribute("userId") int userId,
//                                Model model, HttpServletRequest request) {
//
//        User user = authenticationController.getUserFromSession(request.getSession());
//
//        if (user == null || user.equals("")) {
////            model.addAttribute("title", "user: " + ((User) optUser.get()).getUserId());
//            assert user != null;
//            model.addAttribute("profile", user.getProfile());
//            model.addAttribute("title", "Delete Profile");
////            model.addAttribute("profile", profileRepository.findAll());
//            model.addAttribute("user", user);
//            return "user/profileView";
//        }
//
////        profile = profileRepository.findByUserId(userId);
//        profile = user.getProfile();
//        Integer profileId = profile.getUserId();
//        profileRepository.deleteById(profileId);
////        userRepository.save(user);
//        {
////        if (optUser.isPresent()) {
////            User aUser = (User) optUser.get();
////            model.addAttribute("title", "user: " + ((User) optUser.get()).getUserId());
////            model.addAttribute("user", aUser);
////            return "user/profileView";
////        } else {
////            return "redirect:/";
////        }
////        if (userId.isPresent()) {
////            Profile profile = (Profile) result.get();
////        { profileRepository.delete(profile);}
////            {this.profileService.deleteProfileById(profileUserId);}
////        model.addAttribute("profile", profileRepository.findAll());
//            return "index";
//        }






    }
