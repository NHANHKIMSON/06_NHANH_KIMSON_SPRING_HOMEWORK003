package org.example.nhanhkimsonspringhomework003.model.request;


import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginationRequest {
    @Min(value = 1, message = "Page must be greater than 0")
    private Integer page;
    @Min(value = 1, message = "Size must be greater than 0")
    private Integer size;
}
