package com.medinfotracker.medinfotracker.models;

import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;
import com.medinfotracker.medinfotracker.models.data.GoogleCalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


@Service
public class GoogleCalendarServiceImpl implements GoogleCalendarService {

    private static Logger logger = LoggerFactory.getLogger(GoogleCalendarServiceImpl.class);
    private Calendar client;
    private final String APPLICATION_NAME = "MedInfoTracker";
    private HttpTransport httpTransport;
    private final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    private String clientId;
    private String clientSecret;
    private String redirectURI;
    private GoogleClientSecrets clientSecrets;
    private GoogleAuthorizationCodeFlow flow;
    private Credential credential;

    @Autowired
    public GoogleCalendarServiceImpl(GoogleCalendarConfigImpl config) {
        this.clientId = config.getClientId();
        this.clientSecret = config.getClientSecret();
        this.redirectURI = config.getRedirectURI();
    }

    @Override
    public String authorize() {
        AuthorizationCodeRequestUrl authorizationUrl;
        if (flow == null) {
            GoogleClientSecrets.Details web = new GoogleClientSecrets.Details();
            web.setClientId(clientId);
            web.setClientSecret(clientSecret);
            clientSecrets = new GoogleClientSecrets().setWeb(web);
            try {
                httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            } catch (GeneralSecurityException | IOException e) {
                logger.error("Error to send message ", e);
            }
            flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets,
                    Collections.singleton(CalendarScopes.CALENDAR)).setAccessType("offline").build();
        }
        authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(redirectURI);
        return authorizationUrl.build();
    }

    @Override
    public Calendar tokenResponse(String code) {
        try {
            TokenResponse response = flow.newTokenRequest(code).setRedirectUri(redirectURI).execute();
            credential = flow.createAndStoreCredential(response, "userID");
            return client = new Calendar.Builder(httpTransport, JSON_FACTORY, credential)
                    .setApplicationName(APPLICATION_NAME).build();

        } catch (IOException e) {
            logger.warn("Exception while handling OAuth2 callback (" + e.getMessage() + ")."
                    + " Redirecting to google connection status page.");
            logger.error("Error to send message ", e);
        }
        return client;
    }

    @Override
    public void addEvent(String calendarMentor, Long startDate, String skype) throws IOException {
        Event event = newEvent(startDate, skype);
        com.google.api.services.calendar.model.Calendar calendar =
                client.calendars().get(calendarMentor).execute();
        client.events().insert(calendar.getId(), event).execute();
    }

    @Override
    public void update(Long newDate, Long oldDate, String calendarMentor, String skype) {
        try {
            com.google.api.services.calendar.model.Calendar calendar =
                    client.calendars().get(calendarMentor).execute();
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.US);
            String formattedDateOld = ZonedDateTime.ofInstant(Instant.ofEpochMilli(oldDate), ZoneId.systemDefault()).format(outputFormatter);

            List<Event> eventAll = client.events().list(calendar.getId()).execute().getItems();
            Event newEvent = newEvent(newDate, skype);

            for (int i = 0; i < eventAll.size(); i++) {
                if (eventAll.get(i).getStart().toString().contains(formattedDateOld)) {
                    String eventId = eventAll.get(i).getId();
                    client.events().delete(calendarMentor, eventId).execute();
                    client.events().insert(calendar.getId(), newEvent).execute();
                }
            }
        } catch (IOException e) {
            logger.error("Error to send message ", e);
        }
    }

    @Override
    public boolean checkFreeDate(Long date, String calendarMentor) {
        try {
            com.google.api.services.calendar.model.Calendar calendar = client.calendars().get(calendarMentor).execute();
            List<Event> eventAll = client.events().list(calendar.getId()).execute().getItems();

            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.US);
            String formattedDate = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date), ZoneId.systemDefault()).format(outputFormatter);

            for (int i = 0; i < eventAll.size(); i++) {
                if (eventAll.get(i).getStart().toString().contains(formattedDate)) {
                    return true;
                }
            }
        } catch (IOException e) {
            logger.error("Error to send message ", e);
        }
        return false;
    }

//
//    public void read() throws IOException, GeneralSecurityException {
//        // Build a new authorized API client service.
//        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//
//        // List the next 10 events from the primary calendar.
//        DateTime now = new DateTime(System.currentTimeMillis());
//        Events events = service.events().list("primary")
//                .setMaxResults(10)
//                .setTimeMin(now)
//                .setOrderBy("startTime")
//                .setSingleEvents(true)
//                .execute();
//        List<Event> items = events.getItems();
//        if (items.isEmpty()) {
//            System.out.println("No upcoming events found.");
//        } else {
//            System.out.println("Upcoming events");
//            for (Event event : items) {
//                DateTime start = event.getStart().getDateTime();
//                if (start == null) {
//                    start = event.getStart().getDate();
//                }
//                System.out.printf("%s (%s)\n", event.getSummary(), start);
//            }
//        }
//    }

    private Event newEvent(Long startDate, String skype) {
        Event event = new Event();
        event.setSummary("Skype(crm) - " + skype);
        DateTime start = new DateTime(startDate);
        event.setStart(new EventDateTime().setDateTime(start));
        DateTime end = new DateTime(startDate);
        event.setEnd(new EventDateTime().setDateTime(end));
        return event;
    }
}
