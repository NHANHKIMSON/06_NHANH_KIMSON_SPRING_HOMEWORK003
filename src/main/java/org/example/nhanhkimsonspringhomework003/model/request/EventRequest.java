package org.example.nhanhkimsonspringhomework003.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nhanhkimsonspringhomework003.model.Attendee;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {
    private String eventName;
    private String eventDate;
    private String venueId;
    private List<Integer> attendees;

}
