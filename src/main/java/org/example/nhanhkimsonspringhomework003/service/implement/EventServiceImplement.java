package org.example.nhanhkimsonspringhomework003.service.implement;

import lombok.RequiredArgsConstructor;
import org.example.nhanhkimsonspringhomework003.model.Event;
import org.example.nhanhkimsonspringhomework003.repository.EventRepository;
import org.example.nhanhkimsonspringhomework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EventServiceImplement implements EventService {
    private final EventRepository eventRepository;
    @Override
    public List<Event> getAllEvents(Integer page, Integer size) {
        return eventRepository.getAllEvents(page, size);
    }

    @Override
    public List<Event> getEventById(Integer eventId) {
        return eventRepository.getEventById(eventId);
    }

    @Override
    public List<Event> deleteEventById(Integer eventId) {
        return eventRepository.deleteEventById(eventId);
    }
}
