package org.example.nhanhkimsonspringhomework003.service;


import org.example.nhanhkimsonspringhomework003.model.Venue;
import org.example.nhanhkimsonspringhomework003.model.request.VenueRequest;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenues(Integer page, Integer size);
    List<Venue> getVenuesById(Integer id);
    List<Venue> deleteVenuesById(Integer id);

    List<Venue> createNewVenue(VenueRequest venueRequest);

    List<Venue> updateVenue(Integer venueId, VenueRequest venueRequest);
}
