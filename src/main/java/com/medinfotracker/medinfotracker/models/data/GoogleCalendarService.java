package com.medinfotracker.medinfotracker.models.data;

import java.io.IOException;

public interface GoogleCalendarService {

    void addEvent(String calendarMentor, Long startDate, String skype) throws IOException;

    void update(Long newDate, Long oldDate, String calendarMentor, String skype);

//    void read();

    String authorize();

    com.google.api.services.calendar.Calendar tokenResponse(String code);

    boolean checkFreeDate(Long newDate, String calendarMentor);

}
