package org.example.nhanhkimsonspringhomework003.service;

import org.example.nhanhkimsonspringhomework003.model.Attendee;
import org.example.nhanhkimsonspringhomework003.model.request.AttendeeRequest;

import java.util.List;


public interface AttendeeService {
    List<Attendee> createNewAttendee(AttendeeRequest attendeeRequest);

    List<Attendee> updateAttendee(Integer attendeeId, AttendeeRequest attendeeRequest);

    List<Attendee> deleteAttendee(Integer attendeeId);

    List<Attendee> getAttendeeById(Integer attendeeId);

    List<Attendee> getAllAttendee(Integer page, Integer size);
}
