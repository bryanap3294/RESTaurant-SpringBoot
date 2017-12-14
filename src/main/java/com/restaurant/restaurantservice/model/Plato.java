package com.restaurant.restaurantservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="plato")
public class Plato {

	@Id
    private String id;
	
	private String nombrePlato;
	
	private Double precio;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Plato() {
        super();
    }
	
	public String getNombrePlato() {
		return nombrePlato;
	}
	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Plato[id=%s, nombrePlato='%s', precio='%s']",
                id, nombrePlato, precio);
    }

}
