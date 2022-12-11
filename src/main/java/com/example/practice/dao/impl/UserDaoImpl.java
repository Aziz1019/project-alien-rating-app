package com.example.practice.dao.impl;

import com.example.practice.dao.UserDao;
import com.example.practice.dao.config.PostgresConnection;
import com.example.practice.exception.DaoException;
import com.example.practice.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static Connection con = PostgresConnection.getInstance();
    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    private static final String CHECKUSER = "SELECT username, password from users where username = ? and password = ? and is_active = true";
    private static final String IS_ADMIN = "SELECT role from users where username = ? and password = ?";
    private static final String REGISTER = "insert into users(username, password) VALUES (?, ?)";
    private static final String GET_ALL = "SELECT * from users where is_active = true order by status desc";
    private static final String GET_BLOCKED_USERS = "SELECT * from users where is_active = false order by status desc";
    private static final String GET_BY_ID = "SELECT * from users where id = ?";
    private static final String GET_ID = "SELECT id from users where username = ? and password = ?";
    private static final String DELETE = "DELETE FROM users WHERE id = ?";
    private static final String UPDATE = "UPDATE users SET username = ?, status = ?, is_active = ?, role = ?, password = ? WHERE id = ?";
    private static final String BLOCK_USER = "UPDATE users SET is_active = false where id = ?";
    private static final String UPDATE_STATUS_POSITIVE = "UPDATE users set status = status + 5 where id = ?";
    private static final String UPDATE_STATUS_NEGATIVE = "UPDATE users set status = status - 5 where id = ?";

    @Override
    public boolean saveDB(User user) throws DaoException {
        int rowCount = 0;
        try (PreparedStatement statement = con.prepareStatement(REGISTER)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            rowCount = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException();
        }
        return rowCount == 1;
    }

    @Override
    public List<User> getAll() throws DaoException {
        return getUsers(GET_ALL);
    }

    @Override
    public List<User> getAllBlockedUsers() throws DaoException {
        return getUsers(GET_BLOCKED_USERS);
    }

    private List<User> getUsers(String get_users) throws DaoException {
        try (PreparedStatement statement = con.prepareStatement(get_users)) {
            List<User> users = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User u = new User();
                u.setId(resultSet.getInt(1));
                u.setUsername(resultSet.getString(2));
                u.setStatus(resultSet.getInt(3));
                u.setIsActive(resultSet.getBoolean(4));
                u.setRole(resultSet.getString(5));
                u.setCreatedAt(resultSet.getString(6));
                u.setPassword(resultSet.getString(7));
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<User> findById(Long id) throws DaoException {
        try (PreparedStatement statement = con.prepareStatement(GET_BY_ID)) {
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setStatus(resultSet.getInt(3));
                user.setIsActive(resultSet.getBoolean(4));
                user.setRole(resultSet.getString(5));
                user.setCreatedAt(resultSet.getString(6));
                user.setPassword(resultSet.getString(7));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Integer id) throws DaoException {
        int i;
        try (PreparedStatement statement = con.prepareStatement(DELETE);) {
            statement.setInt(1, id);
            i = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return i == 1;
    }

    @Override
    public boolean update(User user) throws DaoException {
        int rowCount;
        try (PreparedStatement statement = con.prepareStatement(UPDATE);) {
            statement.setString(1, user.getUsername());
            statement.setInt(2, user.getStatus());
            statement.setBoolean(3, user.getIsActive());
            statement.setString(4, user.getRole());
            statement.setString(5, user.getPassword());
            statement.setInt(6,user.getId());
            rowCount = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException();
        }
        return rowCount == 1;
    }
    @Override
    public boolean updateStatus(Boolean positive, Integer userId) throws DaoException {
        String updateType = positive ? UPDATE_STATUS_POSITIVE : UPDATE_STATUS_NEGATIVE;
        int rowCount = 0;
        try (PreparedStatement statement = con.prepareStatement(updateType);) {
            statement.setInt(1, userId);
            rowCount = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException();
        }
        return rowCount == 1;
    }
    @Override
    public boolean blockUser(Integer userId) throws DaoException{
        int rowCount;
        try(PreparedStatement statement = con.prepareStatement(BLOCK_USER)) {
            statement.setInt(1, userId);
            rowCount = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return rowCount == 1;
    }
    @Override
    public boolean authenticate(String login, String password) throws DaoException {
        try (PreparedStatement statement = con.prepareStatement(CHECKUSER)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            String loginDb, passDb;
            if (resultSet.next()) {
                loginDb = resultSet.getString(1);
                passDb = resultSet.getString(2);
                if (login.equals(loginDb) && password.equals(passDb)) return true;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return false;
    }
    @Override
    public boolean isAdmin(String login, String password) throws DaoException {
        try (PreparedStatement statement = con.prepareStatement(IS_ADMIN)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            String role;
            if (resultSet.next()) {
                role = resultSet.getString(1);
                if (role.equals("admin")) return true;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return false;
    }
    @Override
    public Integer getIdByUsernameAndPassword(String login, String password) throws DaoException {
        int id = 0;
        try (PreparedStatement statement = con.prepareStatement(GET_ID)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return id;
    }
}
