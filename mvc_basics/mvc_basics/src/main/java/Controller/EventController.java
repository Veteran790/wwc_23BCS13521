package Controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.mvc_basics.model.Event;
import com.example.mvc_basics.Service.EventService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/events")

public class EventController {
    private final EventService eventService;

    public EventController(EventService event){
        this.eventService = event;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        return  ResponseEntity.ok(eventService.getAllEvents());
    }
}
