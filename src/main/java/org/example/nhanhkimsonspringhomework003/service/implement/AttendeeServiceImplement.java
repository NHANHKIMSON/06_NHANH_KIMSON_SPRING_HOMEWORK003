package org.example.nhanhkimsonspringhomework003.service.implement;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.SneakyThrows;
import org.example.nhanhkimsonspringhomework003.exception.NotFoundException;
import org.example.nhanhkimsonspringhomework003.model.Attendee;
import org.example.nhanhkimsonspringhomework003.model.request.AttendeeRequest;
import org.example.nhanhkimsonspringhomework003.repository.AttendeeRepository;
import org.example.nhanhkimsonspringhomework003.service.AttendeeService;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


@Service
public class AttendeeServiceImplement implements AttendeeService {
    private final AttendeeRepository attendeeRepository;
    public AttendeeServiceImplement(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }
    @Override
    public List<Attendee> createNewAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.createNewAttendee(attendeeRequest);
    }

    @Override
    public List<Attendee> updateAttendee(Integer attendeeId, AttendeeRequest attendeeRequest) {
        return attendeeRepository.updateAttendee(attendeeId, attendeeRequest);
    }

    @Override
    public List<Attendee> deleteAttendee(Integer attendeeId) {
        return attendeeRepository.deleteAttendee(attendeeId);
    }

    @Override
    public List<Attendee> getAttendeeById(Integer attendeeId) {
        List<Attendee> attendees = attendeeRepository.getAttendeeById(attendeeId);
        if (attendees.isEmpty()) {
            throw new NotFoundException("Attendee not found");
        }
        return attendees;
    }


    @Override
    public List<Attendee> getAllAttendee(
            Integer page,
            Integer size) {
        return attendeeRepository.getAllAttendee(page, size);
    }
}
