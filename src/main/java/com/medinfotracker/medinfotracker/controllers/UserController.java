package com.medinfotracker.medinfotracker.controllers;
//import com.medinfotracker.medinfotracker.models.Profile;
//import com.medinfotracker.medinfotracker.models.User;
//import com.medinfotracker.medinfotracker.models.data.ProfileRepository;
//import com.medinfotracker.medinfotracker.models.data.UserRepository;
//import com.medinfotracker.medinfotracker.models.dto.RegisterFormDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//import java.util.Optional;
//
//@Controller
////@SessionAttributes("user")
//@RequestMapping("user")
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private ProfileRepository profileRepository;
//    @Autowired
//    private AuthenticationController authenticationController;
//
//    @GetMapping("addProfile")
//    public String displayAddProfileForm(Model model) {
//
//        model.addAttribute("User Medical Record Name", "Add User Medical Record Name");
//        model.addAttribute("User Address", "Add User Address");
//        model.addAttribute("User Phone Number", "Add User Phone Number");
////        model.addAttribute("Preferred Pronouns","My preferred pronouns are: ");
//        model.addAttribute("Emergencys Contact Name", "Add Emergency Contact Name");
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
//        return "/user/addProfile";
//    }
//    @PostMapping("addProfile")
//    public String processAddProfileForm(@ModelAttribute @Valid Profile newProfile,
//                                        Errors errors, Model model, HttpServletRequest request) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add User Profile Details");
//            return "/user/addProfile";
//        }
//
//        User user = authenticationController.getUserFromSession(request.getSession());
//
//        profileRepository.save(newProfile);
//        user.setProfile(newProfile);
//        userRepository.save(user);
////        model.addAttribute("user", userRepository.findAll());
//        model.addAttribute("profile", profileRepository.findAll());
//        return "redirect:..";
//    }
//
//    //    If I try to get the user from the session, I get: An Errors/BindingResult argument is expected to be declared
//    //    immediately after the model attribute, the @RequestBody or the @RequestPart arguments to which they apply: public
//    //    java.lang.String com.medinfotracker.medinfotracker.controllers.UserController.displayViewUserProfile
//    //    (org.springframework.ui.Model,javax.servlet.http.HttpServletRequest,org.springframework.validation.Errors,java.lang.String)
//    //    java.lang.IllegalStateException: An Errors/BindingResult argument is expected to be declared immediately after the model attribute,
//    //    the @RequestBody or the @RequestPart arguments to which they apply: public java.lang.String
//    @GetMapping("profileView/{userId}")
//    public String displayViewUserProfile(Model model, RegisterFormDTO registerFormDTO, Errors errors,
//                                         @PathVariable("userId") int userId) {
////        model.addAttribute("user", userRepository.findById(profile_id));
//
//        User existingUser = userRepository.findByUserName(registerFormDTO.getUserName());
//        if (existingUser != null) {
//            errors.rejectValue("userName", "userName.alreadyExists", "That username is already in use.");
//            model.addAttribute("title", "Register");
//            return "user/profileView";
//        }
//        Optional optUser = userRepository.findById(userId);
//        if (optUser.isPresent()) {
//            User user = (User) optUser.get();
//            model.addAttribute("title", "user: " + ((User) optUser.get()).getUserId());
//            model.addAttribute("user", user);
//            return "user/profileView";
//        } else {
//            return "redirect:/";
//        }
//    }
//}











//package com.medinfotracker.medinfotracker.controllers;


import com.medinfotracker.medinfotracker.models.Profile;
import com.medinfotracker.medinfotracker.models.User;
import com.medinfotracker.medinfotracker.models.data.ProfileRepository;
import com.medinfotracker.medinfotracker.models.data.UserRepository;
import com.medinfotracker.medinfotracker.models.dto.RegisterFormDTO;
import com.medinfotracker.medinfotracker.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
//@SessionAttributes("user")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private ProfileService profileService;

    @GetMapping("addProfile")
    public String displayAddProfileForm(Model model) {

        model.addAttribute("Preferred Name","Add User Preferred Name");
        model.addAttribute("User Medical Record Name", "Add User Medical Record Name");
        model.addAttribute("User Address", "Add User Address");
        model.addAttribute("User Phone Number", "Add User Phone Number");
        model.addAttribute("Preferred Pronouns","My preferred pronouns are:");
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
        return "/user/addProfile";
    }

    @PostMapping("addProfile")
    public String processAddProfileForm(@ModelAttribute @Valid Profile newProfile,
                                        Errors errors, Model model, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User Profile Details");
            return "/user/addProfile";
        }

        User user = authenticationController.getUserFromSession(request.getSession());

        profileRepository.save(newProfile);
        user.setProfile(newProfile);
        userRepository.save(user);
//        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("profile", profileRepository.findAll());
        return "redirect:..";
    }


//    If I try to get the user from the session, I get: An Errors/BindingResult argument is expected to be declared
//    immediately after the model attribute, the @RequestBody or the @RequestPart arguments to which they apply: public
//    java.lang.String com.medinfotracker.medinfotracker.controllers.UserController.displayViewUserProfile
//    (org.springframework.ui.Model,javax.servlet.http.HttpServletRequest,org.springframework.validation.Errors,java.lang.String)
//    java.lang.IllegalStateException: An Errors/BindingResult argument is expected to be declared immediately after the model attribute,
//    the @RequestBody or the @RequestPart arguments to which they apply: public java.lang.String
@GetMapping("profileView/{userId}")
public String displayViewUserProfile(Model model, RegisterFormDTO registerFormDTO, Errors errors,
                                     @PathVariable("userId") int userId) {
//        model.addAttribute("user", userRepository.findById(profile_id));

    User existingUser = userRepository.findByUserName(registerFormDTO.getUserName());
    if (existingUser != null) {
        errors.rejectValue("userName", "userName.alreadyExists", "That username is already in use.");
        model.addAttribute("title", "Register");
        return "user/profileView";
    }
    Optional optUser = userRepository.findById(userId);
    if (optUser.isPresent()) {
        User user = (User) optUser.get();
        model.addAttribute("title", "user: " + ((User) optUser.get()).getUserId());
        model.addAttribute("user", user);
        return "user/profileView";
    } else {
        return "redirect:/";
    }
}



//}

//
//
//    @GetMapping("/updateProfile/{profileUserId}")
//    public String displayFormForUpdate(@PathVariable("profileUserId") int profileUserId, Model model) {
//
//        if (!model.containsAttribute("profileUserId")) {
//            Profile profile = profileRepository.findById(profileUserId).orElseThrow(()
//            -> new IllegalArgumentException("Invalid Profile" + profileUserId));
//            model.addAttribute("profile", profile);
//        }
//
//        return "updateProfile";
//    }

//    @PostMapping("/updateProfile/{profileId}")
//    public String processFormForUpdate(@Validated @ModelAttribute("profile") Profile profile, @RequestParam() int profileId,
//                                       @RequestParam(required = false) String userMedicalRecordName, String userAddress, String userPhoneNumber,
//                                       String userDateOfBirth, String emergencyName, String emergencyPhoneNumber, String emergencyRelationship,
//                                       String primaryCarePhysicianName, String primaryCarePhysicianAddress, String primaryCarePhysicianPhoneNumber,
//                                       String specialistName, String specialistPhoneNumber, String specialistType,
//                                       String allergies, String medicalConditions, BindingResult bindingResult,
//                                       RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest, SessionStatus sessionStatus) {
//        User user = authenticationController.getUserFromSession(httpServletRequest.getSession());
//
//        if (!bindingResult.hasErrors()) {
//            try {
//                Optional result = profileRepository.findById(profileId);
//                if (result.isPresent()) {
//                    Profile aProfile = (Profile) result.get();
//                    profileRepository.save(aProfile);
//                    user.setProfile(aProfile);
//                    userRepository.save(user);
//                }
//            }
//                catch (JpaOptimisticLockingFailureException exception) {
//
//                }
//
//    }



//    @PostMapping("deleteProfile")
    @RequestMapping(value = "deleteProfile/{profileUserId}", method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteProfile(@ModelAttribute("profile") Profile profile,
//                                @RequestParam(required = false)
                                @ModelAttribute("profileUserId") String profileUserId,
                                Model model, HttpServletRequest request) {

        User user = authenticationController.getUserFromSession(request.getSession());

        if (user == null || user.equals("")) {
//            model.addAttribute("title", "user: " + ((User) optUser.get()).getUserId());
            assert user != null;
            model.addAttribute("profile", user.getProfile());
            model.addAttribute("title", "Delete Profile");
            model.addAttribute("profile", profileRepository.findAll());
            model.addAttribute("user", user);
            return "user/profileView";
        }

        profile = profileRepository.findByUserId(Integer.valueOf(profileUserId));
        {
//        if (optUser.isPresent()) {
//            User aUser = (User) optUser.get();
//            model.addAttribute("title", "user: " + ((User) optUser.get()).getUserId());
//            model.addAttribute("user", aUser);
//            return "user/profileView";
//        } else {
//            return "redirect:/";
//        }
//        if (userId.isPresent()) {
//            Profile profile = (Profile) result.get();
//        { profileRepository.delete(profile);}
            {this.profileService.deleteProfileById(profileUserId);}
        model.addAttribute("profile", profileRepository.findAll());
        return "index";
    }



//        if (userId == null || userId.equals("")) {

//            User user = authenticationController.getUserFromSession(request.getSession());
//            model.addAttribute("profile", user.getProfile());
//            model.addAttribute("title", "Delete Profile");
//            model.addAttribute("profile", profileRepository.findAll());
//            model.addAttribute("user", user);
//
////            if (userId == null || userId.equals("")) {
////    }
//      Optional result = null; <-- this threw a Null Exception, below was suggested fix
//        Optional result = Optional.empty();
//        if (userId != null) {
//            result = profileRepository.findById(Integer.parseInt(userId));
//        }


}}
