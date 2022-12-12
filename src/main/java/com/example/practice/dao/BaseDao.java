package com.example.practice.dao;

import com.example.practice.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {

    boolean saveDB(T t) throws DaoException;

    List<T> getAll() throws DaoException;

    Optional<T> findById(Long id) throws DaoException;

    boolean deleteById(Integer id) throws DaoException;

    boolean update(T t) throws DaoException;


}