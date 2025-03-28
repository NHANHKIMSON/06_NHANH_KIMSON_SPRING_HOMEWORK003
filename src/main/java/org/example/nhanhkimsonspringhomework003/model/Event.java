package org.example.nhanhkimsonspringhomework003.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private String eventId;
    private String eventName;
    private String eventDate;
    private Venue venue;
    private List<Attendee> attendees;
}

