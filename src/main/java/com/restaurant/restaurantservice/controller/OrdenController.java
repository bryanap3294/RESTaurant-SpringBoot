package com.restaurant.restaurantservice.controller;

import javax.validation.Valid;
import com.restaurant.restaurantservice.model.Orden;
import com.restaurant.restaurantservice.repository.OrdenRepository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OrdenController {
	
	private static final Logger logger = LogManager.getLogger(OrdenController.class);

	@Autowired
    OrdenRepository ordenRepository;

    @GetMapping("/orden")
    public List<Orden> getAllOrdens() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        //no acepta debug ni fatal
        logger.info("Info log");
        return ordenRepository.findAll(sortByCreatedAtDesc);
    }

    @PostMapping("/orden")
    public Orden createOrden(@Valid @RequestBody Orden orden) {
    		orden.setEstado(1);
        return ordenRepository.save(orden);
    }

    @GetMapping(value="/orden/{id}")
    public ResponseEntity<Orden> getOrdenById(@PathVariable("id") String id) {
        Orden orden = ordenRepository.findOne(id);
        if(orden == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(orden, HttpStatus.OK);
        }
    }

    @PutMapping(value="/orden/{id}")
    public ResponseEntity<Orden> updateOrden(@PathVariable("id") String id,
                                           @Valid @RequestBody Orden orden) {
        Orden ordenData = ordenRepository.findOne(id);
        if(ordenData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ordenData.setNombreCliente(orden.getNombreCliente());
        ordenData.setEstado(orden.getEstado());
        Orden updatedOrden = ordenRepository.save(ordenData);
        return new ResponseEntity<>(updatedOrden, HttpStatus.OK);
    }

    @DeleteMapping(value="/orden/{id}")
    public void deleteOrden(@PathVariable("id") String id) {
    		ordenRepository.delete(id);
    }
	
}