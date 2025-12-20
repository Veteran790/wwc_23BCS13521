package com.example.mvc_basics.model;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private int id;
    private String name;
    private String course;

    public Event(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    public static void main(String[] args) {
        List<Event> students = new ArrayList<>();
        Event a = new Event(101,"Goru","Hotel Management");
        Event b = new Event(102,"Kiru","CSE");
        Event c = new Event(103,"Chiku","Aerospace");
        students.addEvent(a);
        students.addEvent(b);
        students.addEvent(c);
    }

}
