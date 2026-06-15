package com.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.catalog.model.Review;
import com.catalog.repository.ReviewRepository;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/testsave")
    public String testSave() {

        Review review = new Review();

        review.setProductId(1L);
        review.setComment("MongoDB Test");
        review.setRating(5);

        reviewRepository.save(review);

        return "Saved Successfully";
    }
}