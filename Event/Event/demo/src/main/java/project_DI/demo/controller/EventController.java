package project_DI.demo.controller;

import project_DI.demo.model.Event;
import project_DI.demo.service.EventService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>>getAllEvents(){
        return ResponseEntity.ok(eventService.getAllEvents());
    }
}
