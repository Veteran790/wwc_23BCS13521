package project_DI.demo.service;

import project_DI.demo.model.Event;
import project_DI.demo.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventService {
    private List<Event> events = new ArrayList<>();
    public List<project_DI.demo.model.Event> getAllEvents(){
        return events;
    }

    public Event getEventById(int id){
        return events.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Event addEvent(Event event){
        events.add(event);
        return  event;
    }
    public boolean deleteEvent(int id){
        return events.removeIf(e -> e.getId() == id);
    }
}
