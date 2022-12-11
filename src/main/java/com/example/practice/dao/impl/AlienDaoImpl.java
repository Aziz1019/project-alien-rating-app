package com.example.practice.dao.impl;

import com.example.practice.dao.AlienDao;
import com.example.practice.dao.config.PostgresConnection;
import com.example.practice.exception.DaoException;
import com.example.practice.model.Alien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlienDaoImpl implements AlienDao {

    private static Connection con = PostgresConnection.getInstance();
    private static AlienDao instance;

    public static AlienDao getInstance() {
        if (instance == null) {
            instance = new AlienDaoImpl();
        }
        return instance;
    }

    private final String GET_ALL = "select a.id,a.alien_name, a.source, u.username, a.created_at, a.image_url\n" +
            "from aliens a\n" +
            "left join users u on u.id = a.created_by";
    private final String GET_ONE = "select * from aliens where id = ?";
    private final String INSERT = "INSERT into aliens(alien_name, source, created_by, image_url) values(?, ?, ?, ?)";
    private final String DELETE = "delete from aliens where id = ?";
    private final String UPDATE = "update aliens set alien_name = ?, source = ?, image_url = ? where id = ?";
    @Override
    public boolean saveDB(Alien alien) throws DaoException {
        int rowCount;
        try (PreparedStatement statement = con.prepareStatement(INSERT)) {
            statement.setString(1, alien.getAlienName());
            statement.setString(2, alien.getSource());
            statement.setInt(3, Integer.parseInt(alien.getCreatedBy()));
            statement.setString(4, alien.getImageUrl());
            rowCount = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return rowCount == 1;
    }

    @Override
    public List<Alien> getAll() throws DaoException {
        try (PreparedStatement statement = con.prepareStatement(GET_ALL)) {
            ResultSet rs = statement.executeQuery();
            List<Alien> aliens = new ArrayList<>();
            while (rs.next()) {
                Alien alien = new Alien();
                alien.setId(rs.getInt(1));
                alien.setAlienName(rs.getString(2));
                alien.setSource(rs.getString(3));
                alien.setCreatedBy(rs.getString(4));
                alien.setCreatedAt(rs.getString(5));
                alien.setImageUrl(rs.getString(6));
                aliens.add(alien);
            }
            return aliens;
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public Optional<Alien> findById(Long id) throws DaoException {
        Alien alien = new Alien();
        try (PreparedStatement statement = con.prepareStatement(GET_ONE)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                alien.setId(resultSet.getInt(1));
                alien.setAlienName(resultSet.getString(2));
                alien.setSource(resultSet.getString(3));
                alien.setCreatedBy(String.valueOf(resultSet.getInt(4)));
                alien.setCreatedAt(resultSet.getString(5));
                alien.setImageUrl(resultSet.getString(6));
            }
            return Optional.of(alien);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        int rowCount = 0;
        try (PreparedStatement statement = con.prepareStatement(DELETE);) {
            statement.setInt(1, id);
            rowCount = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return rowCount == 1;
    }

    @Override
    public boolean update(Alien alien) throws DaoException {
        int rowCount;
        try (PreparedStatement statement = con.prepareStatement(UPDATE);) {
            statement.setString(1, alien.getAlienName());
            statement.setString(2, alien.getSource());
            statement.setString(3, alien.getImageUrl());
            statement.setInt(4, alien.getId());

            rowCount = statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException();
        }
        return rowCount == 1;
    }
}
