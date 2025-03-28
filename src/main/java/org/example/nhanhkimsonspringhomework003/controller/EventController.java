package org.example.nhanhkimsonspringhomework003.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.nhanhkimsonspringhomework003.model.Event;
import org.example.nhanhkimsonspringhomework003.model.request.EventRequest;
import org.example.nhanhkimsonspringhomework003.model.response.ApiResponse;
import org.example.nhanhkimsonspringhomework003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    @Operation(summary = "get All detail events")
    ResponseEntity<ApiResponse<List<Event>>> getAllEvents(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        ApiResponse<List<Event>> apiResponse = ApiResponse.<List<Event>>builder()
                .message("Get all events has successfully!")
                .payload(eventService.getAllEvents(page, size))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("{event-id}")
    @Operation(summary = "get events by id")
    ResponseEntity<ApiResponse<List<Event>>> getEventById(
            @PathVariable("event-id") Integer eventId
    ) {
        ApiResponse<List<Event>> apiResponse = ApiResponse.<List<Event>>builder()
                .message("Get events by id has successfully!")
                .payload(eventService.getEventById(eventId))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


    @DeleteMapping("{event-id}")
    @Operation(summary = "Delete events by id")
    ResponseEntity<ApiResponse<List<Event>>> deleteEventById(
            @PathVariable("event-id") Integer eventId
    ) {
        ApiResponse<List<Event>> apiResponse = ApiResponse.<List<Event>>builder()
                .message("Delete events by id has successfully!")
                .payload(eventService.deleteEventById(eventId))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    @Operation(summary = "Create new event")
    ResponseEntity<ApiResponse<List<Event>>> createEvent(
            @RequestBody EventRequest eventRequest
    ){
        ApiResponse<List<Event>> apiResponse = ApiResponse.<List<Event>>builder()
                .message("New event was created successfully")
                .payload(eventService.createNewEvent(eventRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


    @PutMapping({"{event-id}"})
    @Operation(summary = "Event was updated successfully")
    ResponseEntity<ApiResponse<List<Event>>> updateEvent(
            @PathVariable("event-id") Integer eventId,
            @RequestBody EventRequest eventRequest
    ){
        ApiResponse<List<Event>> apiResponse = ApiResponse.<List<Event>>builder()
                .message("New event was created successfully")
                .payload(eventService.updateEvent(eventId, eventRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
