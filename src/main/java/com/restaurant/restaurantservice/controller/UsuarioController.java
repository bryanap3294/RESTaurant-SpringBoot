package com.restaurant.restaurantservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurantservice.model.Usuario;
import com.restaurant.restaurantservice.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UsuarioController {

	private static final Logger logger = LogManager.getLogger(UsuarioController.class);
	
	@Autowired
    UsuarioRepository usuarioRepository;
	
	@Autowired
	MongoOperations mongoOperations;

    @GetMapping("/user")
    public List<Usuario> getAllUsers() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        //no acepta debug ni fatal
        logger.info("Log get USER");
        return usuarioRepository.findAll(sortByCreatedAtDesc);
    }
    
    @PostMapping("/user")
    public Usuario createTodo(@Valid @RequestBody Usuario user) {
    		logger.info("Log post USER"+ user);
        return usuarioRepository.save(user);
    }
    
    public Usuario getByUserName(String username) {
    		logger.info("Buscando usuario: "+ username);
        return mongoOperations.findOne(
                Query.query(Criteria.where("username").is(username)),
                Usuario.class,
                "users");
    }
	
}
