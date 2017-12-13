package com.restaurant.restaurantservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.restaurant.restaurantservice.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}