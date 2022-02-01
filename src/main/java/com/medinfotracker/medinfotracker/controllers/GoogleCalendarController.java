package com.medinfotracker.medinfotracker.controllers;

import com.medinfotracker.medinfotracker.models.data.GoogleCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

    @Controller
    public class GoogleCalendarController {
        private final GoogleCalendarService calendarService;

        @Autowired
        public GoogleCalendarController(GoogleCalendarService calendarService) {
            this.calendarService = calendarService;
        }

        @RequestMapping(value = "/login/google", method = RequestMethod.GET, params = "code")
        public RedirectView oauth2Callback(@RequestParam(value = "code") String code) {
            calendarService.tokenResponse(code);
            return new RedirectView("/login/google");
        }

        @RequestMapping(value = "/login/google", method = RequestMethod.GET)
        public RedirectView googleConnectionStatus() {
            return new RedirectView(calendarService.authorize());
        }
    }
