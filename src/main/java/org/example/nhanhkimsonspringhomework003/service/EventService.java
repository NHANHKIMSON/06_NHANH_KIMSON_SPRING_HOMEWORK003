package org.example.nhanhkimsonspringhomework003.service;

import org.example.nhanhkimsonspringhomework003.model.Event;
import org.example.nhanhkimsonspringhomework003.model.request.EventRequest;

import java.util.List;


public interface EventService {
    List<Event> getAllEvents(Integer page, Integer size);

    List<Event> getEventById(Integer eventId);

    List<Event> deleteEventById(Integer eventId);

    List<Event> createNewEvent(EventRequest eventRequest);

    List<Event> updateEvent(Integer eventId, EventRequest eventRequest);
}
