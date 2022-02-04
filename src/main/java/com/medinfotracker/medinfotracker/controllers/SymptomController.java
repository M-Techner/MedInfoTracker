package com.medinfotracker.medinfotracker.controllers;


import com.medinfotracker.medinfotracker.models.Symptoms;
import com.medinfotracker.medinfotracker.models.data.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("symptom")
public class SymptomController {

    /**
     *
     *
     */
    @Autowired
    private SymptomRepository symptomRepository;


    @GetMapping("")
    public String index(Model model){
        model.addAttribute("Symptom Name", "symptomName");
        model.addAttribute("Start Date", "startDate");
        model.addAttribute("Stop Date", "stopDate");
        model.addAttribute("Symptom Description", "symptomDescribe");
//        return "symptoms/view";
//        return "symptoms/index";
        return "redirect:../";
    }
    @GetMapping("add")
    public String displayAddSymptomsForm(Model model) {
        model.addAttribute(new Symptoms());
        return "symptoms/add";
    }
    @PostMapping("add")
    public String processAddSymptomsForm(@Valid Symptoms newSymptoms,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "symptoms/add";
        }

        symptomRepository.save(newSymptoms);
        return "redirect:";
    }
    @GetMapping("view/{symptomsId}")
    public String displayViewSymptoms(Model model, @PathVariable int symptomsId) {

        Optional optSymptoms = symptomRepository.findById(symptomsId);
        if (optSymptoms.isPresent()) {
            Symptoms symptoms = (Symptoms) optSymptoms.get();
            model.addAttribute("symptoms", symptoms);
            return "symptoms/view";
        } else {
            return "redirect:../";
        }
    }
}
