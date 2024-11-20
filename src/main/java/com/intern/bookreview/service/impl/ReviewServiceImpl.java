package com.intern.bookreview.service.impl;

import com.intern.bookreview.dto.ReviewDTO;
import com.intern.bookreview.entity.Review;
import com.intern.bookreview.exception.CustomException;
import com.intern.bookreview.repository.ReviewRepository;
import com.intern.bookreview.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final ModelMapper mapper;

    @Override
    public ReviewDTO addReview(ReviewDTO reviewDTO) {
        reviewDTO.setAddedDate(Timestamp.valueOf(LocalDateTime.now()));
        Review review = mapper.map(reviewDTO, Review.class);
        return mapper.map(repository.save(review), ReviewDTO.class);
    }

    @Override
    public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO) {
        if (!repository.existsById(id)) {
            throw new CustomException("Review not found", HttpStatus.NOT_FOUND);
        }
        Review review = mapper.map(reviewDTO, Review.class);
        return mapper.map(repository.save(review), ReviewDTO.class);
    }

    @Override
    public boolean deleteReview(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        return repository.findAll().stream().map(review -> mapper.map(review, ReviewDTO.class)).toList();
    }

    @Override
    public ReviewDTO getReviewById(Long id) {
        Review review = repository.findById(id).orElseThrow(() -> new CustomException("Review not found", HttpStatus.NOT_FOUND));
        return mapper.map(review, ReviewDTO.class);
    }
}
