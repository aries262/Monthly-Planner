package com.codepath.monthlyplanner.Models;

import java.util.ArrayList;

import io.realm.RealmObject;

public class CalendarItem extends RealmObject {
    public String event;
    public String description;
    public String time;
    public String location;
    public String reminder;

    public CalendarItem(String event, String description, String time, String location, String reminder){
        this.event = event;
        this.description = description;
        this.time = time;
        this.location = location;
        this.reminder = reminder;
    }

    public String getEvent() {return event;}
    public String getDescription() {return description;}
    public String getTime() {return time;}
    public String getLocation() {return location;}
    public String getReminder() {return reminder;}

    public static ArrayList<CalendarItem> getItems() {
        ArrayList<CalendarItem> items = new ArrayList<CalendarItem>();

        return items;
    }
}
