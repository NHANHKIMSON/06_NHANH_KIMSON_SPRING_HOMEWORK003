package org.example.nhanhkimsonspringhomework003.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendee {
    private Integer attendeeId;
    private String attendeeName;
    private String email;
}
