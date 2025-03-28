package org.example.nhanhkimsonspringhomework003.repository;


import org.apache.ibatis.annotations.*;
import org.example.nhanhkimsonspringhomework003.model.Venue;
import org.example.nhanhkimsonspringhomework003.model.request.VenueRequest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Properties;

@Mapper
public interface VenueRepository {
    @Select("""
    SELECT * FROM venues
    OFFSET #{size} * (#{page} -1)
    limit #{size};
    """)
    @Results(id = "venueRequest", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name")
    })
    List<Venue> getAllVenues(Integer page, Integer size);
    @Select("""
    SELECT * FROM venues WHERE venue_id = #{venueId}
    """)
    @ResultMap("venueRequest")
    List<Venue> getVenuesById(Integer venueId);


    @Select("""
    DELETE FROM venues WHERE venue_id = #{venueId}
    RETURNING *
    """)
    @ResultMap("venueRequest")
    List<Venue> deleteVenuesById(Integer venueId);

    @Select("""
    INSERT INTO venues (venue_name, location)
    VALUES (#{venueRequest.venueName}, #{venueRequest.location})
    RETURNING *
    """)
    @ResultMap("venueRequest")
    List<Venue> createNewVenue(@Param("venueRequest") VenueRequest venueRequest);




    @Select("""
    UPDATE venues SET venue_name = #{venueRequest.venueName},
    location  = #{venueRequest.location} WHERE venue_id = #{venueId}
    RETURNING *
    """)
    @ResultMap("venueRequest")
    List<Venue> updateVenue(Integer venueId, VenueRequest venueRequest);
}
