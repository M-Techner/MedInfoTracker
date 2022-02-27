package com.medinfotracker.medinfotracker.controllers;

import com.medinfotracker.medinfotracker.Models.Medication;
import com.medinfotracker.medinfotracker.Models.User;
import com.medinfotracker.medinfotracker.Models.data.MedicationRepository;
import com.medinfotracker.medinfotracker.Models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("medication")
public class MedicationController<newProfile, user, newMedication> {
    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;

    public MedicationController() {
    }

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

        medicationRepository.save(newMedication);
        model.addAttribute("medication", medicationRepository.findAll());

        User user = authenticationController.getUserFromSession(request.getSession());
        //user.setMedication(newMedication);
        //medicationRepository.save(user);
    model.addAttribute("medication", medicationRepository.findAll());
        return "redirect:";
    }




    //User user = authenticationController.getUserFromSession(request.getSession());
    //user.setProfile(newProfile);
    //profileRepository.save(user);
    //model.addAttribute("profile, profileRepository.findAll"());
    //return "redirect";
//}



    @GetMapping("view/{id}")
    public String displayViewMedication(Model model, @PathVariable int id) {
        model.addAttribute("medication", medicationRepository.findAll());
        Optional optMedication = medicationRepository.findById(id);
        if (optMedication.isPresent()) {
            Medication medication = (Medication) optMedication.get();
            model.addAttribute("medication", medication);
            return "medication/view";
        } else {
            return "redirect:..";
        }

    }

}

