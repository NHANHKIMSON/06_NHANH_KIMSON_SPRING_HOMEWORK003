package org.example.nhanhkimsonspringhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.nhanhkimsonspringhomework003.model.Event;
import org.example.nhanhkimsonspringhomework003.model.request.EventRequest;

import java.util.List;

@Mapper
public interface EventRepository {
    @Select("""
    SELECT * FROM events
    LIMIT #{size} OFFSET #{size} * (#{page} - 1);
    """)
    @Results(id="EventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id", one = @One(select = "org.example.nhanhkimsonspringhomework003.repository.VenueRepository.getVenuesById")),
            @Result(property = "attendees", column = "event_id", many = @Many(select = "org.example.nhanhkimsonspringhomework003.repository.AttendeeRepository.getAttendeeByEventId"))
    })
    List<Event> getAllEvents(Integer page, Integer size);


    @Select("""
    SELECT * FROM events WHERE event_id = #{eventId}
    """)
    @ResultMap("EventMapper")
    List<Event> getEventById(Integer eventId);


    @Select("""
    DELETE FROM events WHERE event_id = #{eventId}
    RETURNING *
    """)
    @ResultMap("EventMapper")
    List<Event> deleteEventById(Integer eventId);


    @Select("""
    INSERT INTO events (event_name, event_date,venue_id)
    VALUES (#{eventRequest.eventName}, #{eventRequest.eventDate}, #{eventRequest.venueId})
    RETURNING *
    """)
    @ResultMap("EventMapper")
    Event creteNewEvent(@Param("eventRequest") EventRequest eventRequest);



    @Select("""
    UPDATE events  SET event_name = #{eventRequest.eventName}, event_date = #{eventRequest.eventDate} ,venue_id = #{eventRequest.venueId}
    WHERE event_id = #{eventId}
    RETURNING *
    """)
    @ResultMap("EventMapper")
    Event updateEvent(Integer eventId, @Param("eventRequest") EventRequest eventRequest);
}
