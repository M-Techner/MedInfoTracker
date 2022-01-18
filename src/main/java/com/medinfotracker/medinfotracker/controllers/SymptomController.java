package com.medinfotracker.medinfotracker.controllers;


import com.medinfotracker.medinfotracker.models.data.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("symptom")
public class SymptomController {

    @Autowired
    private SymptomRepository symptomRepository;


    @GetMapping("")
    public String index(Model model){

   }
}