package com.votacion_antiv1.votacion_anti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votacion_antiv1.votacion_anti.models.Login;
import com.votacion_antiv1.votacion_anti.models.Usuario;
import com.votacion_antiv1.votacion_anti.repositories.UsuarioRepository;
import com.votacion_antiv1.votacion_anti.security.SHAHashing;



@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	private SHAHashing bCryptPasswordEncoder = new SHAHashing();

	@PostMapping
	public Usuario login(@RequestBody Login user) {
		Usuario usuario = usuarioRepository.findByIdentificacion(user.getIdentificacion());
		if (usuario == null)
			return null;
		
		if (usuario.getContrasena().equalsIgnoreCase(bCryptPasswordEncoder.encode(user.getContrasena())))
			return usuario;

		return null;
	}

}
