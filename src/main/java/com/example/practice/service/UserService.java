package com.example.practice.service;

import com.example.practice.exception.DaoException;
import com.example.practice.exception.ServiceException;
import com.example.practice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean authenticate(String login, String password) throws ServiceException;
    boolean registerUser(User user)throws ServiceException;
    boolean update(User user)throws ServiceException;
    boolean deleteById(Integer id)throws ServiceException;
    Optional<User> findById(Long id)throws ServiceException;
    List<User> getAll()throws ServiceException;
    boolean blockUser(Integer userId) throws ServiceException;
    List<User> getAllBlockedUsers() throws ServiceException;
    boolean isAdmin(String login, String password) throws ServiceException;
    Integer getIdByUsernameAndPassword(String login, String password) throws ServiceException;

    boolean updateStatus(Boolean positive, Integer userId) throws ServiceException;

}
