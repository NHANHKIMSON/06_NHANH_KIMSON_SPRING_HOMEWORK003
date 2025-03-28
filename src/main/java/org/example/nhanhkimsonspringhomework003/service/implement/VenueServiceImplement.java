package org.example.nhanhkimsonspringhomework003.service.implement;


import org.example.nhanhkimsonspringhomework003.model.Venue;
import org.example.nhanhkimsonspringhomework003.model.request.VenueRequest;
import org.example.nhanhkimsonspringhomework003.repository.VenueRepository;
import org.example.nhanhkimsonspringhomework003.service.VenueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VenueServiceImplement implements VenueService {

    private final VenueRepository venueRepository;
    public VenueServiceImplement(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> getAllVenues(Integer page, Integer size) {
        return venueRepository.getAllVenues(page, size);
    }

    @Override
    public List<Venue> getVenuesById(Integer id) {
        return venueRepository.getVenuesById(id);
    }

    @Override
    public List<Venue> deleteVenuesById(Integer id) {
        return venueRepository.deleteVenuesById(id);
    }

    @Override
    public List<Venue> createNewVenue(VenueRequest venueRequest) {
        return venueRepository.createNewVenue(venueRequest);
    }

    @Override
    public List<Venue> updateVenue(Integer venueId, VenueRequest venueRequest) {
        return venueRepository.updateVenue(venueId, venueRequest);
    }
}
