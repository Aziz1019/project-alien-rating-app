package com.example.practice.dao;

import com.example.practice.exception.DaoException;
import com.example.practice.model.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {
    boolean authenticate(String login, String password) throws DaoException;
    boolean blockUser(Integer userId) throws DaoException;
    List<User> getAllBlockedUsers() throws DaoException;
    boolean isAdmin(String login, String password) throws DaoException;
    Integer getIdByUsernameAndPassword(String login, String password) throws DaoException;
    boolean updateStatus(Boolean positive, Integer userId) throws DaoException;
    List<User> getAllUsers() throws  DaoException;

}