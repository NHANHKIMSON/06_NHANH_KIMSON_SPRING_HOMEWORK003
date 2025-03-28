package org.example.nhanhkimsonspringhomework003.controller;


import org.example.nhanhkimsonspringhomework003.model.Venue;
import org.example.nhanhkimsonspringhomework003.model.request.VenueRequest;
import org.example.nhanhkimsonspringhomework003.model.response.ApiResponse;
import org.example.nhanhkimsonspringhomework003.repository.VenueRepository;
import org.example.nhanhkimsonspringhomework003.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenueRestController {
    private final VenueService venueService;
    public VenueRestController(VenueService venueService) {
        this.venueService = venueService;
    }
    @GetMapping
    ResponseEntity<ApiResponse<List<Venue>>> getAllVenues(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        ApiResponse<List<Venue>> apiResponse = ApiResponse.<List<Venue>>builder()
                .message("Get all venues was successfully")
                .payload(venueService.getAllVenues(page, size))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @GetMapping("{venue-id}")
    ResponseEntity<ApiResponse<List<Venue>>> getVenuesById(@RequestParam("venue-id") Integer id) {
        ApiResponse<List<Venue>> apiResponse = ApiResponse.<List<Venue>>builder()
                .message("Get venue by has successfully")
                .payload(venueService.getVenuesById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("{venue-id}")
    ResponseEntity<ApiResponse<List<Venue>>> deleteVenuesById(@RequestParam("venue-id") Integer id) {
        ApiResponse<List<Venue>> apiResponse = ApiResponse.<List<Venue>>builder()
                .message("Get venue by has successfully")
                .payload(venueService.deleteVenuesById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    ResponseEntity<ApiResponse<List<Venue>>> createNewVenue(
            @RequestBody VenueRequest venueRequest
    ) {
        ApiResponse<List<Venue>> apiResponse = ApiResponse.<List<Venue>>builder()
                .message("Create new venue has successfully")
                .payload(venueService.createNewVenue(venueRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping({"{venue-id}"})
    ResponseEntity<ApiResponse<List<Venue>>> updateVenue(
            @PathVariable("venue-id") Integer venueId,
            @RequestBody VenueRequest venueRequest
    ) {
        ApiResponse<List<Venue>> apiResponse = ApiResponse.<List<Venue>>builder()
                .message("Update new venue has successfully")
                .payload(venueService.updateVenue(venueId,venueRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
