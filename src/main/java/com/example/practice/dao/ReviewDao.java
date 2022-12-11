package com.example.practice.dao;

import com.example.practice.exception.DaoException;
import com.example.practice.model.Review;

public interface ReviewDao extends BaseDao<Review>{
    Double getAverageRating(Integer alienId) throws DaoException;
    Integer getNumberOfRating(Integer alienId) throws DaoException;
}
