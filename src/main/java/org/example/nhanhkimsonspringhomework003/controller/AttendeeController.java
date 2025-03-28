package org.example.nhanhkimsonspringhomework003.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.example.nhanhkimsonspringhomework003.model.Attendee;
import org.example.nhanhkimsonspringhomework003.model.request.AttendeeRequest;
import org.example.nhanhkimsonspringhomework003.model.response.ApiResponse;
import org.example.nhanhkimsonspringhomework003.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;
    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @PostMapping
    @Operation(summary = "Create new attendee")
    ResponseEntity<ApiResponse<List<Attendee>>> createNewAttendee(@RequestBody AttendeeRequest attendeeRequest) {
        ApiResponse<List<Attendee>> createNewAttendee = ApiResponse.<List<Attendee>>builder()
                .message("New attendee was created successfully!")
                .payload(attendeeService.createNewAttendee(attendeeRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(createNewAttendee);
    }

    @PutMapping("{attendee-id}")
    @Operation(summary = "Update attendee")
    ResponseEntity<ApiResponse<List<Attendee>>> updateAttendee(
            @PathVariable("attendee-id") Integer attendeeId,
            @RequestBody AttendeeRequest attendeeRequest) {
        ApiResponse<List<Attendee>> createNewAttendee = ApiResponse.<List<Attendee>>builder()
                .message("Attendee was updated successfully!")
                .payload(attendeeService.updateAttendee(attendeeId ,attendeeRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(createNewAttendee);
    }

    @DeleteMapping("{attendee-id}")
    @Operation(summary = "Delete attendee")
    ResponseEntity<ApiResponse<List<Attendee>>> deleteNewAttendee(
            @PathVariable("attendee-id") Integer attendeeId)
    {
        ApiResponse<List<Attendee>> createNewAttendee = ApiResponse.<List<Attendee>>builder()
                .message("Attendee was deleted successfully!")
                .payload(attendeeService.deleteAttendee(attendeeId))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(createNewAttendee);
    }

    @GetMapping("{attendee-id}")
    @Operation(summary = "Select attendee by id")
    ResponseEntity<ApiResponse<List<Attendee>>> getAttendeeById(
            @PathVariable("attendee-id") Integer attendeeId)
    {
        ApiResponse<List<Attendee>> createNewAttendee = ApiResponse.<List<Attendee>>builder()
                .message("Attendee was selected successfully!")
                .payload(attendeeService.getAttendeeById(attendeeId))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(createNewAttendee);
    }

    @GetMapping
    @Operation(summary = "Get all attendee")
    ResponseEntity<ApiResponse<List<Attendee>>> getAllAttendee(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size)
    {
        ApiResponse<List<Attendee>> createNewAttendee = ApiResponse.<List<Attendee>>builder()
                .message("Attendee was selected successfully!")
                .payload(attendeeService.getAllAttendee(page, size))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(createNewAttendee);
    }
}
