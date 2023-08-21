package ru.alexanderbary.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexanderbary.ems.model.Event;
import ru.alexanderbary.ems.service.EventService;
import ru.alexanderbary.ems.util.ErrorResponse;
import ru.alexanderbary.ems.util.EventNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents() {
        return eventService.findAll();
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(EventNotFoundException e) {
        ErrorResponse response = new ErrorResponse(
                "Event with this id wasn't found.",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable("id") Long id) {
        return eventService.findOne(id);
    }


    @PostMapping
    public void create(@RequestBody Event event) {
        this.eventService.save(event);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Event event) {
        this.eventService.update(id, event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.eventService.delete(id);
    }





}
