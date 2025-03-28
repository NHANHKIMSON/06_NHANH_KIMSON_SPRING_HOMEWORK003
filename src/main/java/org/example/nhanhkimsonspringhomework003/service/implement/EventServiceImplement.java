package org.example.nhanhkimsonspringhomework003.service.implement;

import lombok.RequiredArgsConstructor;
import org.example.nhanhkimsonspringhomework003.model.Event;
import org.example.nhanhkimsonspringhomework003.model.request.EventRequest;
import org.example.nhanhkimsonspringhomework003.repository.AttendeeRepository;
import org.example.nhanhkimsonspringhomework003.repository.EventRepository;
import org.example.nhanhkimsonspringhomework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EventServiceImplement implements EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;


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

    @Override
    public List<Event> createNewEvent(EventRequest eventRequest) {
        Event event = eventRepository.creteNewEvent(eventRequest);

        for (Integer attendeeId : eventRequest.getAttendees()) {
            attendeeRepository.insertAttendeeEvent(event.getEventId(), attendeeId);
        }
        return eventRepository.getEventById(event.getEventId());
    }

    @Override
    public List<Event> updateEvent(Integer eventId, EventRequest eventRequest) {
        Event event = eventRepository.updateEvent(eventId, eventRequest);
        System.out.println(event);
        attendeeRepository.deleteAttendeeEvent(eventId);
        for (Integer attendeeId : eventRequest.getAttendees()) {
            System.out.println(attendeeId);
            attendeeRepository.insertAttendeeEvent(eventId, attendeeId);
        }
        return eventRepository.getEventById(event.getEventId());
    }
}
