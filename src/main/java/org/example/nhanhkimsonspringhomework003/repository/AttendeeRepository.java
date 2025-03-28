package org.example.nhanhkimsonspringhomework003.repository;


import org.apache.ibatis.annotations.*;
import org.example.nhanhkimsonspringhomework003.model.Attendee;
import org.example.nhanhkimsonspringhomework003.model.request.AttendeeRequest;

import java.util.List;
@Mapper
public interface AttendeeRepository {
    @Select("""
    INSERT INTO attendees VALUES (default,#{attendeeRequest.attendeeName},#{attendeeRequest.email} )
    RETURNING *
    """)

    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name"),
            @Result(property = "email", column = "email"),
    })
    List<Attendee> createNewAttendee(@Param("attendeeRequest") AttendeeRequest attendeeRequest);



    @Select("""
    UPDATE attendees
    SET attendee_name = #{attendeeRequest.attendeeName},
    email = #{attendeeRequest.email} WHERE attendee_id = #{attendeeId}
    RETURNING *
    """)
    @ResultMap("attendeeMapper")
    List<Attendee> updateAttendee(Integer attendeeId, AttendeeRequest attendeeRequest);



    @Select("""
    DELETE FROM attendees WHERE attendee_id = #{attendeeId}
    RETURNING *
    """)
    @ResultMap("attendeeMapper")
    List<Attendee> deleteAttendee(Integer attendeeId);

    @Select("""
    SELECT * FROM attendees WHERE attendee_id = #{attendeeId}
    """)
    @ResultMap("attendeeMapper")
    List<Attendee> getAttendeeById(Integer attendeeId);


    @Select("""
    SELECT * FROM attendees
    OFFSET #{size} * (#{page} -1)
    limit #{size};
    """)
    @ResultMap("attendeeMapper")
    List<Attendee> getAllAttendee(Integer page, Integer size);
}
