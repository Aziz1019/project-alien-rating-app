package com.example.practice.service.impl;

import com.example.practice.dao.UserDao;
import com.example.practice.dao.impl.UserDaoImpl;
import com.example.practice.exception.DaoException;
import com.example.practice.exception.ServiceException;
import com.example.practice.model.User;
import com.example.practice.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    private final UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public boolean authenticate(String login, String password) {
        boolean match = false;
        if (!login.isBlank() || !password.isBlank()) {
            try {
                match = userDao.authenticate(login, password);
            } catch (DaoException e) {
                throw new RuntimeException();
            }
        }
        return match;
    }

    @Override
    public boolean registerUser(User user) {
        try {
            return userDao.saveDB(user);
        } catch (DaoException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean update(User user) {
        try {
            return userDao.update(user);
        } catch (DaoException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            return userDao.deleteById(id);
        } catch (DaoException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        try {
            return userDao.findById(id);
        } catch (DaoException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return userDao.getAll();
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean blockUser(Integer userId) {
        try {
            return userDao.blockUser(userId);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllBlockedUsers() {
        try {
            return userDao.getAllBlockedUsers();
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isAdmin(String login, String password) {
        try {
            return userDao.isAdmin(login, password);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getIdByUsernameAndPassword(String login, String password) {
        try {
            return userDao.getIdByUsernameAndPassword(login, password);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateStatus(Boolean positive, Integer userId) {
        try {
            return userDao.updateStatus(positive, userId);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userDao.getAllUsers();
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }


}
