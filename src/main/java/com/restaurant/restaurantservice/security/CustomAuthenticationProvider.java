package com.restaurant.restaurantservice.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.restaurant.restaurantservice.controller.UsuarioController;
import com.restaurant.restaurantservice.model.Usuario;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	UsuarioController usuarioController;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
        String password = authentication.getCredentials().toString();         
        Usuario user = usuarioController.getByUserName(username);
    
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        } else {
            return null;
        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(
		          UsernamePasswordAuthenticationToken.class);
	}

}
