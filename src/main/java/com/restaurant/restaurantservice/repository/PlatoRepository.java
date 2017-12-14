package com.restaurant.restaurantservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.restaurant.restaurantservice.model.Plato;

public interface PlatoRepository extends MongoRepository<Plato, String>{

}
