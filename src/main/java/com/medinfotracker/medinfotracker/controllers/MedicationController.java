package com.medinfotracker.medinfotracker.controllers;

import com.medinfotracker.medinfotracker.models.Medication;
import com.medinfotracker.medinfotracker.models.data.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("medication")
public class MedicationController {
    @Autowired
    private MedicationRepository medicationRepository;

    @GetMapping(value = "addMed")
    public String displayAddMedicationForm(Model model) {


        model.addAttribute("Medication Name","add Medication Name");
        model.addAttribute("Date Started","add Date Started");
        model.addAttribute("Prescribing Physician", "add Prescribing Physician");
        model.addAttribute("Dosage", "add Dosage");
        model.addAttribute("Frequency", "add Frequency");
        model.addAttribute("Route Of Administration", "add Route Of Administration");
        model.addAttribute("Refill", "add Refill");
        model.addAttribute("Over the Counter", "add Over the Counter");
        model.addAttribute(new Medication());
        return "/medication/addMed";
    }

    @PostMapping(value = "addMed")
    public String processAddMedicationForm(@ModelAttribute @Valid Medication newMedication, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Medication Information");
            return "/medication/addMed";
        }

        medicationRepository.save(newMedication);
        model.addAttribute("medication", medicationRepository.findAll());
        return "redirect:..";

    }
    @GetMapping("view/{userId}")
    public String displayViewMedication(Model model, @PathVariable int userId) {
        model.addAttribute("medication", medicationRepository.findAll());
        Optional optMedication = medicationRepository.findById(userId);
        if (optMedication.isPresent()) {
            Medication medication = (Medication) optMedication.get();
            model.addAttribute("medication", medication);
            return "/medication/view";
        } else {
            return "redirect:..";
        }

    }

}















