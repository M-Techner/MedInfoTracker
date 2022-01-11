package com.medinfotracker.medinfotracker.controllers;

Import.com.medinfotracker.medinfotracker.models.user;
Import.com.medinfotracker.medinfotracker.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class SearchController {




import static org.medinfotracker.controllers.ListController.columnChoices;

    /**
     * Created by LaunchCode
     */
    @Controller
    @RequestMapping("search")
    public class SearchController {

        @Autowired
        private JobRepository jobRepository;

        @RequestMapping("")
        public String search(Model model) {
            model.addAttribute("columns", columnChoices);
            return "search";
        }

        @PostMapping("results")
        public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
            Iterable<Job> jobs;
            if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
                jobs = jobRepository.findAll();
            } else {
                jobs = JobData.findByColumnAndValue(searchType, searchTerm, jobRepository.findAll());
            }
            model.addAttribute("columns", columnChoices);
            model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
            model.addAttribute("jobs", jobs);

            return "search";
        }
