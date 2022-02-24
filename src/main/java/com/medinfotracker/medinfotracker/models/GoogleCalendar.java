//package com.medinfotracker.medinfotracker.models;
//
//import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.auth.oauth2.TokenResponse;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.HttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.util.DateTime;
//import com.google.api.services.calendar.Calendar;
//import com.google.api.services.calendar.model.Event;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.view.RedirectView;
//
//import javax.servlet.http.HttpServletRequest;
//import java.text.SimpleDateFormat;
//import java.util.Collections;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//
//public class GoogleCalendar {
//
//
//
//import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
//        import com.google.api.client.auth.oauth2.Credential;
//        import com.google.api.client.auth.oauth2.TokenResponse;
//        import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//        import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//        import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
//        import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//        import com.google.api.client.http.HttpTransport;
//        import com.google.api.client.json.JsonFactory;
//        import com.google.api.client.json.jackson2.JacksonFactory;
//        import com.google.api.client.util.DateTime;
//        import com.google.api.services.calendar.Calendar;
//        import com.google.api.services.calendar.Calendar.Builder;
//        import com.google.api.services.calendar.Calendar.Events;
//        import com.google.api.services.calendar.model.Event;
//        import java.text.SimpleDateFormat;
//        import java.util.Collections;
//        import java.util.Date;
//        import java.util.Iterator;
//        import java.util.List;
//        import javax.servlet.http.HttpServletRequest;
//        import org.apache.commons.logging.Log;
//        import org.apache.commons.logging.LogFactory;
//        import org.springframework.beans.factory.annotation.Value;
//        import org.springframework.http.HttpStatus;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.stereotype.Controller;
//        import org.springframework.web.bind.annotation.RequestMapping;
//        import org.springframework.web.bind.annotation.RequestMethod;
//        import org.springframework.web.bind.annotation.RequestParam;
//        import org.springframework.web.servlet.view.RedirectView;
//
//@Controller
//public class GoogleCalController {
//    private static final Log logger = LogFactory.getLog(GoogleCalController.class);
//    private static final String APPLICATION_NAME = "Google Calender APi";
//    private static HttpTransport httpTransport;
//    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//    GoogleAuthorizationCodeFlow flow;
//    @Value("${google.client.client-id}")
//    private String clientId;
//    @Value("${google.client.client-secret}")
//    private String clientSecret;
//    @Value("${google.client.redirectUri}")
//    private String redirectURI;
//    final DateTime currentDate = new DateTime(System.currentTimeMillis());
//
//    public GoogleCalController() {
//    }
//
//    @RequestMapping(
//            value = {"/login/google"},
//            method = {RequestMethod.GET}
//    )
//    public RedirectView googleConnectionStatus(HttpServletRequest request) throws Exception {
//        return new RedirectView(this.authorize());
//    }
//
//    @RequestMapping(
//            value = {"/Callback"},
//            method = {RequestMethod.GET},
//            params = {"code"}
//    )
//    public ResponseEntity<String> oauth2Callback(@RequestParam("code") String code) {
//        StringBuilder message = new StringBuilder();
//
//        try {
//            TokenResponse response = this.flow.newTokenRequest(code).setRedirectUri(this.redirectURI).execute();
//            Credential credential = this.flow.createAndStoreCredential(response, "userID");
//            Calendar client = (new Calendar.Builder(httpTransport, JSON_FACTORY, credential)).setApplicationName("Google Calender APi").build();
//            Calendar.Events events = client.events();
//            com.google.api.services.calendar.model.Events eventList = (com.google.api.services.calendar.model.Events)events.list("primary").setTimeMax(this.currentDate).execute();
//            List<Event> items = eventList.getItems();
//            if (items.isEmpty()) {
//                message.append("No upcoming events found.");
//            } else {
//                message.append("Upcoming events  ");
//
//                Event event;
//                DateTime start;
//                for(Iterator var9 = items.iterator(); var9.hasNext(); message.append(getTime(start).substring(0, 5)).append(" - ").append(getTime(event.getEnd().getDateTime())).append(" : ").append(event.getSummary()).append("\n")) {
//                    event = (Event)var9.next();
//                    start = event.getStart().getDateTime();
//                    if (start == null) {
//                        start = event.getStart().getDate();
//                    }
//                }
//            }
//
//            System.out.println("---- Available time slot ----");
//            getAvailableTimeSlot(eventList);
//        } catch (Exception var12) {
//            logger.warn("Exception while handling OAuth2 callback (" + var12.getMessage() + "). Redirecting to google connection status page.");
//            message.append("Exception while handling OAuth2 callback (").append(var12.getMessage()).append(").").append(" Redirecting to google connection status page.");
//        }
//
//        return new ResponseEntity(message.toString(), HttpStatus.OK);
//    }
//
//    public static void getAvailableTimeSlot(com.google.api.services.calendar.model.Events events) {
//        List<Event> items = events.getItems();
//        String firstEvent = getTime(((Event)items.get(0)).getEnd().getDateTime());
//        int firstEventEndTime = 0;
//        int nextEventStartTime = 0;
//
//        for(int i = 1; i < items.size(); ++i) {
//            String nextEvent = getTime(((Event)items.get(i)).getStart().getDateTime());
//
//            int k;
//            for(k = 0; k < 5; ++k) {
//                firstEventEndTime += firstEvent.charAt(k);
//            }
//
//            for(k = 0; k < 5; ++k) {
//                nextEventStartTime += nextEvent.charAt(k);
//            }
//
//            if (firstEventEndTime != nextEventStartTime) {
//                System.out.println(firstEvent + " - " + nextEvent);
//            }
//
//            firstEvent = nextEvent;
//        }
//
//    }
//
//    public static String getTime(DateTime start) {
//        Date date = new Date(start.getValue() + (long)start.getTimeZoneShift());
//        SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
//        return dateFormat.format(date);
//    }
//
//    private String authorize() throws Exception {
//        if (this.flow == null) {
//            GoogleClientSecrets.Details web = new GoogleClientSecrets.Details();
//            web.setClientId(this.clientId);
//            web.setClientSecret(this.clientSecret);
//            GoogleClientSecrets clientSecrets = (new GoogleClientSecrets()).setWeb(web);
//            httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//            this.flow = (new com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, Collections.singleton("https://www.googleapis.com/auth/calendar.readonly"))).build();
//        }
//
//        AuthorizationCodeRequestUrl authorizationUrl = this.flow.newAuthorizationUrl().setRedirectUri(this.redirectURI);
//        return authorizationUrl.build();
//    }
//}
