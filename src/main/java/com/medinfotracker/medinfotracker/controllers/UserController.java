package com.medinfotracker.medinfotracker.controllers;


import com.medinfotracker.medinfotracker.models.Profile;
import com.medinfotracker.medinfotracker.models.User;
import com.medinfotracker.medinfotracker.models.data.ProfileRepository;
import com.medinfotracker.medinfotracker.models.data.UserRepository;
import com.medinfotracker.medinfotracker.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController extends Profile{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AuthenticationController authenticationController;


    @GetMapping("addProfile")
    public String displayAddProfileForm(Model model) {
        model.addAttribute("Preferred Name", "Add User Preferred Name");
        model.addAttribute("Preferred Pronouns", "My preferred pronouns are:");
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

        profileRepository.save(newProfile);
        user.setProfile(newProfile);
        userRepository.save(user);
//        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("profile", profileRepository.findAll());
        return "redirect:..";
    }



    @GetMapping("profileView/{userId}")
    public String displayViewUserProfile(Model model, HttpServletRequest request) {
//        model.addAttribute("user", userRepository.findById(profile_id));

        User existingUser = authenticationController.getUserFromSession(request.getSession());
//        if (existingUser != null) {
//            existingUser.getProfile();
            model.addAttribute("user", existingUser);
            model.addAttribute("userId", existingUser.getUserId());
            model.addAttribute("profile", existingUser.getProfile());

        return "user/profileView";
    }


//        User existingUser = userRepository.findByUserName(userName);
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
//            return "redirect:./";
//        }
//    }


    @GetMapping("updateProfile/{userId}")
    public String displayFormForUpdate(Model model, HttpServletRequest request) {

//            (@Validated @ModelAttribute("profile") Profile profile, @PathVariable("userId") int userId,
//                                       String userName, Model model, HttpServletRequest request, Errors errors) {

        User updateUser = authenticationController.getUserFromSession(request.getSession());
//        if (existingUser != null) {
//            existingUser.getProfile();
        model.addAttribute("user", updateUser);
        model.addAttribute("userId", updateUser.getUserId());
        model.addAttribute("profile", updateUser.getProfile());

//        return "/user/profileView";

//        if (!model.containsAttribute("userId")) {
//            User existingUser = authenticationController.getUserFromSession(request.getSession());
//            model.addAttribute("user", existingUser);
////            model.addAttribute("userId", existingUser.getUserId());
//            model.addAttribute("profile", existingUser.getProfile());
//            return "user/updateProfile";
//        }
//        User existingUser = authenticationController.getUserFromSession(request.getSession());
//        model.addAttribute("user", existingUser);
////        model.addAttribute("userId", existingUser.getProfile());
//        model.addAttribute("profile", profile);

//        User existingUser = userRepository.findByUserName(userName);
//        if (existingUser != null) {
//            errors.rejectValue("userName", "userName.alreadyExists", "That username is already in use.");
//            model.addAttribute("title", "Register");
//            return "user/updateProfile";
//        }
//        Optional optUser = userRepository.findById(userId);
//        if (optUser.isPresent()) {
//            User user = (User) optUser.get();
//            model.addAttribute("title", "user: " + ((User) optUser.get()).getUserId());
//            model.addAttribute("user", user);
//            return "user/updateProfile";
//        } else {
            return "user/updateProfile";
        }
//    }


    @PostMapping("updateProfile/{userId}")
    public String processFormForUpdate(@Validated @ModelAttribute("profile") Profile profile,
                                       @RequestParam(required = false) String userPreferredName, @RequestParam(required = false) String userPreferredPronouns,
                                       @RequestParam(required = false) String userMedicalRecordName, @RequestParam(required = false) String userAddress,
                                       @RequestParam(required = false) String userPhoneNumber, @RequestParam(required = false) String userDateOfBirth,
                                       @RequestParam(required = false) String emergencyName, @RequestParam(required = false) String emergencyPhoneNumber,
                                       @RequestParam(required = false) String emergencyRelationship, @RequestParam(required = false) String primaryCarePhysicianName,
                                       @RequestParam(required = false) String primaryCarePhysicianAddress, @RequestParam(required = false) String primaryCarePhysicianPhoneNumber,
                                       @RequestParam(required = false) String specialistName, @RequestParam(required = false) String specialistPhoneNumber,
                                       @RequestParam(required = false) String specialistType, @RequestParam(required = false) String allergies,
                                       @RequestParam(required = false) String medicalConditions, BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                       HttpServletRequest request, SessionStatus sessionStatus) {

        User user = authenticationController.getUserFromSession(request.getSession());
        if (!bindingResult.hasErrors()) {
            try {
                profile = user.getProfile();
                if (userPreferredName == null) {
                   String newUserPreferredName = profile.getUserPreferredName();
                    profile.setUserPreferredName(newUserPreferredName);
                } else {
                    profile.setUserPreferredName(userPreferredName);
                }
                if (userPreferredPronouns == null) {
                    String newUserPreferredPronouns = profile.getUserPreferredPronouns();
                    profile.setUserPreferredPronouns(newUserPreferredPronouns);
                } else {
                    profile.setUserPreferredPronouns(userPreferredPronouns);
                }
                if(userMedicalRecordName == null) {
                    String newUserMedicalRecordName = profile.getUserMedicalRecordName();
                    profile.setUserMedicalRecordName(newUserMedicalRecordName);
                } else {
                    profile.setUserMedicalRecordName(userMedicalRecordName);
                }
                if (userAddress == null) {
                    String newUserAddress = profile.getUserAddress();
                    profile.setUserAddress(newUserAddress);
                } else {
                    profile.setUserAddress(userAddress);
                }
                if (userPhoneNumber == null) {
                    String newUserPhoneNumber = profile.getUserPhoneNumber();
                    profile.setUserPhoneNumber(newUserPhoneNumber);
                } else {
                    profile.setUserPhoneNumber(userPhoneNumber);
                }
                if (userDateOfBirth == null) {
                    String newUserDateOfBirth = profile.getUserDateOfBirth();
                    profile.setUserDateOfBirth(newUserDateOfBirth);
                } else {
                    profile.setUserDateOfBirth(userDateOfBirth);
                }
                if (emergencyName == null) {
                    String newEmergencyName = profile.getEmergencyName();
                    profile.setEmergencyName(newEmergencyName);
                } else {
                    profile.setEmergencyName(emergencyName);
                }
                if (emergencyPhoneNumber == null) {
                    String newEmergencyPhoneNumber = profile.getEmergencyPhoneNumber();
                    profile.setEmergencyPhoneNumber(newEmergencyPhoneNumber);
                } else {
                    profile.setEmergencyPhoneNumber(emergencyPhoneNumber);
                }
                if (emergencyRelationship == null) {
                    String newEmergencyRelationship = profile.getEmergencyRelationship();
                    profile.setEmergencyRelationship(newEmergencyRelationship);
                } else {
                    profile.setEmergencyRelationship(emergencyRelationship);
                }
                if (primaryCarePhysicianName == null) {
                    String newPrimaryCarePhysicianName = profile.getPrimaryCarePhysicianName();
                    profile.setPrimaryCarePhysicianName(newPrimaryCarePhysicianName);
                } else {
                    profile.setPrimaryCarePhysicianName(primaryCarePhysicianName);
                }
                if (primaryCarePhysicianAddress == null) {
                    String newPrimaryCarePhysicianAddress = profile.getPrimaryCarePhysicianAddress();
                    profile.setPrimaryCarePhysicianAddress(newPrimaryCarePhysicianAddress);
                } else {
                    profile.setPrimaryCarePhysicianAddress(primaryCarePhysicianAddress);
                }
                if (primaryCarePhysicianPhoneNumber == null) {
                    String newPrimaryCarePhysicianPhoneNumber = profile.getPrimaryCarePhysicianPhoneNumber();
                    profile.setPrimaryCarePhysicianPhoneNumber(newPrimaryCarePhysicianPhoneNumber);
                } else {
                    profile.setPrimaryCarePhysicianPhoneNumber(primaryCarePhysicianPhoneNumber);
                }
                if (specialistName == null) {
                    String newSpecialistName = profile.getSpecialistName();
                    profile.setSpecialistName(newSpecialistName);
                } else {
                    profile.setSpecialistName(specialistName);
                }
                if (specialistPhoneNumber == null) {
                    String newSpecialistPhoneNumber = profile.getSpecialistPhoneNumber();
                    profile.setSpecialistPhoneNumber(newSpecialistPhoneNumber);
                } else {
                    profile.setSpecialistPhoneNumber(specialistPhoneNumber);
                }
                if (specialistType == null) {
                    String newSpecialistType = profile.getSpecialistType();
                    profile.setSpecialistType(newSpecialistType);
                } else {
                    profile.setSpecialistType(specialistType);
                }
                if (allergies == null) {
                    String newAllergies = profile.getAllergies();
                    profile.setAllergies(newAllergies);
                } else {
                    profile.setAllergies(allergies);
                }
                if (medicalConditions == null) {
                    String newMedicalConditions = profile.getMedicalConditions();
                    profile.setMedicalConditions(newMedicalConditions);
                } else {
                    profile.setMedicalConditions(medicalConditions);}

                    profileRepository.save(profile);
                    user.setProfile(profile);
                    userRepository.save(user);

            } catch (JpaOptimisticLockingFailureException exception) {
                exception.printStackTrace();
                return "Please Create A Profile Before Trying To Edit It - Thank You!";
            }

            }

    return  "index";
}


    @PostMapping("profileView/{userId}")
    public String deleteProfile( @ModelAttribute User user, Model model, HttpServletRequest request) {

        user = authenticationController.getUserFromSession(request.getSession());

        Profile profile = user.getProfile();
        user.deleteProfile(profile);
        profileRepository.delete(profile);
        userRepository.save(user);


        return "";
    }

}
