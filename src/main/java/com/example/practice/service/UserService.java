package com.example.practice.service;

import com.example.practice.exception.DaoException;
import com.example.practice.exception.ServiceException;
import com.example.practice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean authenticate(String login, String password);
    boolean registerUser(User user);
    boolean update(User user);
    boolean deleteById(Integer id);
    Optional<User> findById(Long id);
    List<User> getAll();
    boolean blockUser(Integer userId);
    List<User> getAllBlockedUsers();
    boolean isAdmin(String login, String password);
    Integer getIdByUsernameAndPassword(String login, String password);
    boolean updateStatus(Boolean positive, Integer userId);
    List<User> getAllUsers();

}
