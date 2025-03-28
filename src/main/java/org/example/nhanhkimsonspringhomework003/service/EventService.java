package org.example.nhanhkimsonspringhomework003.service;

import org.example.nhanhkimsonspringhomework003.model.Event;

import java.util.List;



public interface EventService {
    List<Event> getAllEvents(Integer page, Integer size);

    List<Event> getEventById(Integer eventId);

    List<Event> deleteEventById(Integer eventId);
}
