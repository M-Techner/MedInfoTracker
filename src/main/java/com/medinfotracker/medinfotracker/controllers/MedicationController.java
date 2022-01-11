package com.medinfotracker.medinfotracker.controllers;

import com.medinfotracker.medinfotracker.Models.Medication;
import com.medinfotracker.medinfotracker.Models.data.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("Medication")
public class MedicationController {
    @Autowired
    private MedicationRepository medicationRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("Medication", medicationRepository.findAll());
        return "medication/index";
    }


    @GetMapping(value = "add")
    public String displayAddMedicationForm(Model model) {
        model.addAttribute(new Medication());
        model.addAttribute("Medication Name", "Add Medication Name");
        model.addAttribute("Date Started", "Add Date Started");
        model.addAttribute("Prescribing Physician", "Add Prescribing Physician");
        model.addAttribute("Dosage", "Add Dosage");
        model.addAttribute("Frequency", "Add Frequency");
        model.addAttribute("Route Of Administration", "Add Route Of Administration");
        model.addAttribute("Refill", "Add Refill");
        model.addAttribute("Over the Counter", "Add Over the Counter");

        return "medication/add";

    }

    @PostMapping(value = "add")
    public String processAddMedicationForm(@ModelAttribute @Valid Medication newMedication, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Medication Information");
            return "medication/add";
        }

        medicationRepository.save(newMedication);
        model.addAttribute("medication", medicationRepository.findAll());
        return "redirect:";

    }
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

        //@GetMapping(value = "jobs")
        //public String listJobsByColumnAndValue(Model
            //ArrayList<Job> jobs;
            //if (column.equals("all")){
                //jobs = JobData.findAll();
                //model.addAttribute("title", "All Jobs");
            //} else {
                //jobs = JobData.findByColumnAndValue(column, value);
                //model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
            //}
            //model.addAttribute("jobs", jobs);

            //return "list-jobs";
        //}
    //}