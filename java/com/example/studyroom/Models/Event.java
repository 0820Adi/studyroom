package com.example.studyroom.Models; // Replace with your actual package name

public class Event {
    private String name;
    private String time;
    private String location;
    private String category;

    private int date;

    public Event(String name, String time, String location, String category) {
        this.name = name;
        this.time = time;
        this.location = location;
        this.category = category;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public int getDate() {
        return date;
    }
}
