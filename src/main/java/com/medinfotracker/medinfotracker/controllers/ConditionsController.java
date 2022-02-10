package com.medinfotracker.medinfotracker.controllers;

import com.medinfotracker.medinfotracker.models.Conditions;
import com.medinfotracker.medinfotracker.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("condition")
public class ConditionsController {

    @Autowired
    private ConditionsRepository conditionsRepository;


    @GetMapping("")
    public String index(Model model){
        model.addAttribute("Condition Name", "conditionName");
        model.addAttribute("Condition Description", "conditionDescribe");

        return "conditions/index";
    }
    @GetMapping("add")
    public String displayAddConditionsForm(Model model) {
        model.addAttribute(new Conditions());
        return "conditions/add";
    }
    @PostMapping("add")
    public String processAddConditionsForm(@Valid Conditions newConditions,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "conditions/add";
        }

        conditionsRepository.save(newConditions);
        return "redirect:";
    }
    @GetMapping("view/{conditionsId}")
    public String displayViewConditions(Model model, @PathVariable int conditionsId) {

        Optional optConditions = conditionsRepository.findById(conditionsId);
        if (optConditions.isPresent()) {
            Conditions conditions = (Conditions) optConditions.get();
            model.addAttribute("conditions", conditions);
            return "conditions/view";
        } else {
            return "redirect:../";
        }
    }
}
