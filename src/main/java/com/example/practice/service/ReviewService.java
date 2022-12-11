package com.example.practice.service;


import com.example.practice.model.Review;
import java.util.List;


public interface ReviewService extends BaseService<Review> {
    List<Review> getReviews();
    Double getAverageRating(Integer alienId);
    Integer getNumberOfRating(Integer alienId);
    List<Review> getAllReviews();
}
