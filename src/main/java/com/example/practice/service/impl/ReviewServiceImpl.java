package com.example.practice.service.impl;

import com.example.practice.dao.AlienDao;
import com.example.practice.dao.ReviewDao;
import com.example.practice.dao.impl.AlienDaoImpl;
import com.example.practice.dao.impl.ReviewDaoImpl;
import com.example.practice.exception.DaoException;
import com.example.practice.model.Review;
import com.example.practice.service.AlienService;
import com.example.practice.service.ReviewService;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImpl implements ReviewService {

    private static ReviewService instance;
    public static ReviewService getInstance() {
        if (instance==null){
            instance = new ReviewServiceImpl();
        }
        return instance;
    }

    private final ReviewDao reviewDao = ReviewDaoImpl.getInstance();


    @Override
    public List<Review> getReviews() {
        try {
            return reviewDao.getAll();
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Double getAverageRating(Integer alienId) {
        try {
            return reviewDao.getAverageRating(alienId);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getNumberOfRating(Integer alienId) {
        try {
            return reviewDao.getNumberOfRating(alienId);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Review> getAllReviews() {
        try {
            return reviewDao.getAllReviews();
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean saveDB(Review review) {
        try {
            return reviewDao.saveDB(review);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Review> findById(Long id) {
        try {
            return reviewDao.findById(id);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            return reviewDao.deleteById(id);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Review review) {
        try {
            return reviewDao.update(review);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
}

