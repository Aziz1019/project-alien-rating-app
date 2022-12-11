package com.example.practice.service;

import java.util.List;
import java.util.Optional;

public interface BaseService <T> {
    boolean saveDB(T t);
    Optional<T> findById(Long id);
    boolean deleteById(Integer id);
    boolean update(T t);
}
