package com.medinfotracker.medinfotracker.controllers;


import com.medinfotracker.medinfotracker.models.Symptoms;
import com.medinfotracker.medinfotracker.models.data.*;
import com.medinfotracker.medinfotracker.models.data.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

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
    @GetMapping("addSymptoms")
    public String displayAddSymptomsToUserForm(Model model) {
//        model.addAttribute("Username", "${user.userName}");
        model.addAttribute("User", "userName");
//        return "user/addSymptoms";
        return "addSymptoms";
    }
    @PostMapping("add")
    public String processAddSymptomsForm(@ModelAttribute @Valid Symptoms newSymptoms,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "symptoms/add";
        }

        symptomRepository.save(newSymptoms);
//        userRepository.save(newSymptoms);
        return "redirect:";
    }
    @GetMapping("symptoms/view/{Id}")
    public String displayViewSymptoms(Model model, @PathVariable("id") int id) {

        Optional optSymptoms = symptomRepository.findById(id);
        if (optSymptoms.isPresent()) {
            Symptoms symptoms = (Symptoms) optSymptoms.get();
            model.addAttribute("symptoms", symptoms);
            return "symptoms/view";
        } else {
            return "redirect:";
        }
    }

}
