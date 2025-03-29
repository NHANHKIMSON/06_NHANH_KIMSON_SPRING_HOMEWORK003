package org.example.nhanhkimsonspringhomework003.model;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendee {
    private Integer attendeeId;
    @NotBlank(message = "Attendee Name Can't Be Blank!")
    private String attendeeName;
    @NotBlank(message = "Attendee Email Can't Be Blank!")
    private String email;
}
