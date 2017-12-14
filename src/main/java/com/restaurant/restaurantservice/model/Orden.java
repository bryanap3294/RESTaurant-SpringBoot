package com.restaurant.restaurantservice.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orden")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Orden {
	@Id
    private String id;
    
    @NotBlank
    @Size(max=100)
    private String nombreCliente;
    
    private Integer estado;
    
    private Date createdAt = new Date();
    
    private Double monto;
    
    private List<Plato> platos;

	public Orden() {
        super();
    }
    
    public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

    public Orden(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    public Integer getEstado() {
        return estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}
    
    @Override
    public String toString() {
        return String.format(
                "Orden[id=%s, nombreCliente='%s', completed='%s', monto= '%s', platos='%s']",
                id, nombreCliente, estado, monto, platos);
    }
}