package com.restaurant.restaurantservice.repository;

import com.restaurant.restaurantservice.model.Orden;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdenRepository extends MongoRepository<Orden, String>{

}
