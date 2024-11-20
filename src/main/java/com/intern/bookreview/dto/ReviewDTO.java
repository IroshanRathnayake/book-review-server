package com.intern.bookreview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Long id;
    private String title;
    private String author;
    private Integer rating;
    private String review;
    private Timestamp addedDate;
}
