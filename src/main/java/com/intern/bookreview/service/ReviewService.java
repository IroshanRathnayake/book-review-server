package com.intern.bookreview.service;

import com.intern.bookreview.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    ReviewDTO addReview(ReviewDTO reviewDTO);
    ReviewDTO updateReview(Long id, ReviewDTO reviewDTO);
    boolean deleteReview(Long id);
    List<ReviewDTO> getAllReviews();
    ReviewDTO getReviewById(Long id);
}
