package com.example.practice.service.impl;

import com.example.practice.dao.AlienDao;
import com.example.practice.dao.impl.AlienDaoImpl;
import com.example.practice.exception.DaoException;
import com.example.practice.model.Alien;
import com.example.practice.service.AlienService;

import java.util.List;
import java.util.Optional;

public class AlienServiceImpl implements AlienService {
    private static AlienService instance;
    public static AlienService getInstance() {
        if (instance==null){
            instance = new AlienServiceImpl();
        }
        return instance;
    }

    private final AlienDao alienDao = AlienDaoImpl.getInstance();

    @Override
    public List<Alien> getAliens() {
        try {
            return alienDao.getAll();
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean saveDB(Alien alien) {
        try {
            return alienDao.saveDB(alien);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Alien> findById(Long id) {
        try {
            return alienDao.findById(id);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            return alienDao.deleteById(id);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Alien alien) {
        try {
            return alienDao.update(alien);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
}
