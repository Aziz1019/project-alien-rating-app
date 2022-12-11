package com.example.practice.service;

import com.example.practice.exception.DaoException;
import com.example.practice.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService extends BaseService<Review> {
    List<Review> getReviews();
    Double getAverageRating(Integer alienId);
    Integer getNumberOfRating(Integer alienId);
}
