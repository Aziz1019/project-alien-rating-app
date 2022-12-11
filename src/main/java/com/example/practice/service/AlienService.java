package com.example.practice.service;

import com.example.practice.model.Alien;

import java.util.List;


public interface AlienService extends BaseService<Alien> {
    List<Alien> getAliens();
}
