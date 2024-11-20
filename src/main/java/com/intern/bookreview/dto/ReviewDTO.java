package com.intern.bookreview.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Long id;

    @NotBlank(message = "Required Title")
    private String title;

    @NotBlank(message = "Required Author")
    private String author;

    @NotNull(message = "Required Rating")
    @Min(value = 1, message = "Minimum rating value is 1")
    @Max(value = 5, message = "Maximum rating value is 5")
    private Integer rating;

    @NotBlank(message = "Review content is mandatory")
    private String review;

    private Timestamp addedDate;

}
