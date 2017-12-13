package com.restaurant.restaurantservice.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class Usuario {

	@Id
    private String id;
    
    @NotBlank
    @Size(max=100)
    private String username;
    
    @NotBlank
    private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	@Override
    public String toString() {
        return String.format(
                "Usuario[id=%s, username='%s', password='%s']",
                id, username, password);
    }
	
}
