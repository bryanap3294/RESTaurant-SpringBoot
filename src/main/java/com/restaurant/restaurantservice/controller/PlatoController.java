package com.restaurant.restaurantservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurantservice.model.Plato;
import com.restaurant.restaurantservice.repository.PlatoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PlatoController {

	private static final Logger logger = LogManager.getLogger(PlatoController.class);

	@Autowired
    PlatoRepository platoRepository;

    @GetMapping("/plato")
    public List<Plato> getAllPlatos() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        //no acepta debug ni fatal
        logger.info("Info log");
        return platoRepository.findAll(sortByCreatedAtDesc);
    }
    
    @PostMapping("/plato")
    public Plato createPlato(@Valid @RequestBody Plato plato) {
    		logger.info("plato"+ plato);
        return platoRepository.save(plato);
    }
    
    @GetMapping(value="/plato/{id}")
    public ResponseEntity<Plato> getPlatoById(@PathVariable("id") String id) {
        Plato plato = platoRepository.findOne(id);
        if(plato == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(plato, HttpStatus.OK);
        }
    }

    @PutMapping(value="/plato/{id}")
    public ResponseEntity<Plato> updatePlato(@PathVariable("id") String id,
                                           @Valid @RequestBody Plato plato) {
        Plato platoData = platoRepository.findOne(id);
        if(platoData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        platoData.setNombrePlato(plato.getNombrePlato());
        platoData.setPrecio(plato.getPrecio());
        Plato updatedPlato = platoRepository.save(platoData);
        return new ResponseEntity<>(updatedPlato, HttpStatus.OK);
    }

    @DeleteMapping(value="/plato/{id}")
    		public void deletePlato(@PathVariable("id") String id) {
    		platoRepository.delete(id);
    }
}
