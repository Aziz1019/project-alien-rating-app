package com.example.practice.dao;

import com.example.practice.exception.DaoException;
import com.example.practice.model.Review;

import java.util.List;

public interface ReviewDao extends BaseDao<Review>{
    Double getAverageRating(Integer alienId) throws DaoException;
    Integer getNumberOfRating(Integer alienId) throws DaoException;
    List<Review> getAllReviews() throws DaoException;
}
