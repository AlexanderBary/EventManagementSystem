package ru.alexanderbary.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexanderbary.ems.model.Event;
import ru.alexanderbary.ems.repository.EventRepository;
import ru.alexanderbary.ems.util.EventNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findOne(Long id) {
        Optional<Event> foundEvent = eventRepository.findById(id);
        return foundEvent.orElseThrow(EventNotFoundException::new);
    }

    @Transactional
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Transactional
    public void update(Long id, Event event) {
        event.setId(id);
        eventRepository.save(event);
    }

    @Transactional
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
