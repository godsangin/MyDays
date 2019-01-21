package com.msproject.myhome.mydays;

import java.util.ArrayList;
import java.util.Date;

public class Day {
    ArrayList<Event> events;
    Date date;

    public Day(ArrayList<Event> events, Date date){
        events = new ArrayList<>();
        this.date = date;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
