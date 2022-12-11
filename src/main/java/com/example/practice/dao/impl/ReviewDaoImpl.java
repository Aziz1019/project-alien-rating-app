package com.example.practice.dao.impl;

import com.example.practice.dao.AlienDao;
import com.example.practice.dao.ReviewDao;
import com.example.practice.dao.config.PostgresConnection;
import com.example.practice.exception.DaoException;
import com.example.practice.model.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewDaoImpl implements ReviewDao {
    private static Connection con = PostgresConnection.getInstance();
    private static ReviewDao instance;

    public static ReviewDao getInstance() {
        if (instance == null) {
            instance = new ReviewDaoImpl();
        }
        return instance;
    }

    private static final String INSERT_REVIEW = "INSERT INTO reviews (user_id, alien_id, review, rating) VALUES (?,?,?,?)";
    private static final String GET_ALL_REVIEWS = "SELECT * FROM reviews";

    private static final String GET_OVERALL_RATING_BY_ID = "SELECT count(rating) from reviews where alien_id = ?";
    private static final String GET_AVG_RATING = "SELECT avg(rating) from reviews where alien_id = ?";
    private static final String GET_ONE_REVIEW = "SELECT * FROM reviews WHERE id = ?";

    private static final String DELETE_REVIEW = "DELETE FROM reviews WHERE id = ?";

    private static final String UPDATE_REVIEW = "UPDATE reviews SET user_id = ?, alien_id = ?, review = ?, rating = ? WHERE id = ?";


//    private static final String GET_REVIEWS_BY_ALIEN_ID = "SELECT * FROM reviews WHERE alien_id = ?";

    @Override
    public boolean saveDB(Review review) throws DaoException {
        try (PreparedStatement statement = con.prepareStatement(INSERT_REVIEW)){
            statement.setInt(1, review.getUserId());
            statement.setInt(2, review.getAlienId());
            statement.setString(3, review.getReview());
            statement.setInt(4, review.getRating());

            int i = statement.executeUpdate();

            return i == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getNumberOfRating(Integer alienId) throws DaoException{
        try (PreparedStatement statement = con.prepareStatement(GET_AVG_RATING)){
            statement.setInt(1, alienId);
            ResultSet resultSet = statement.executeQuery();
            int numberOfRating = 0;
            if(resultSet.next()){
                numberOfRating = resultSet.getInt(1);
            }
            return numberOfRating;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Double getAverageRating(Integer alienId) throws DaoException {
        try (PreparedStatement statement = con.prepareStatement(GET_AVG_RATING)){
            statement.setInt(1,alienId);
            ResultSet resultSet = statement.executeQuery();
            double avgRating = 0.0;
            while (resultSet.next()){
                 avgRating = resultSet.getDouble(1);
            }
            return avgRating;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Review> getAll() throws DaoException {
        List<Review> reviews = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(GET_ALL_REVIEWS)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Review review = new Review();
                review.setId(resultSet.getInt("id"));
                review.setUserId(resultSet.getInt("user_id"));
                review.setAlienId(resultSet.getInt("alien_id"));
                review.setReview(resultSet.getString("review"));
                review.setRating(resultSet.getInt("rating"));
                review.setCreatedAt(resultSet.getString("created_at"));
                reviews.add(review);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }

    @Override
    public Optional<Review> findById(Long id) throws DaoException {
        try (PreparedStatement statement = con.prepareStatement(GET_ONE_REVIEW)){
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Review review = new Review();
                review.setId(resultSet.getInt("id"));
                review.setUserId(resultSet.getInt("user_id"));
                review.setAlienId(resultSet.getInt("alien_id"));
                review.setReview(resultSet.getString("review"));
                review.setRating(resultSet.getInt("rating"));
                review.setCreatedAt(resultSet.getString("created_at"));
                return Optional.of(review);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        try (PreparedStatement statement = con.prepareStatement(DELETE_REVIEW)){
            statement.setInt(1, id);

            int i = statement.executeUpdate();

            return i == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Review review) throws DaoException {
        try (PreparedStatement statement = con.prepareStatement(UPDATE_REVIEW)){
            statement.setInt(1, review.getUserId());
            statement.setInt(2, review.getAlienId());
            statement.setString(3, review.getReview());
            statement.setInt(4, review.getRating());
            statement.setInt(5, review.getId());
            int i = statement.executeUpdate();
            return i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
