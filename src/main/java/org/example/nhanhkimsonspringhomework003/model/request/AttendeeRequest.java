package org.example.nhanhkimsonspringhomework003.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AttendeeRequest {
    private String attendeeName;
    private String email;
}
