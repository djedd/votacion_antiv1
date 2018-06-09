package com.votacion_antiv1.votacion_anti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votacion_antiv1.votacion_anti.models.Usuario;
import com.votacion_antiv1.votacion_anti.repositories.UsuarioRepository;
import com.votacion_antiv1.votacion_anti.security.SHAHashing;


@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	//se utiliza para cifrar la contraseña SHAHashing
	private SHAHashing bCryptPasswordEncoder = new SHAHashing();
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarioList() {
		return new ResponseEntity<List<Usuario>>(usuarioRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") int id) {
		return new ResponseEntity<Usuario>(usuarioRepository.getOne(id), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Void> createUsuario(@RequestBody Usuario usuario) {
		
		usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
		usuarioRepository.save(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable("id") int id) {

		if (usuarioRepository.existsById(id))
			usuarioRepository.delete(usuarioRepository.getOne(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/update")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
		
		Usuario u = usuarioRepository.getOne(usuario.getId_usuario());
		
		if (usuarioRepository.existsById(usuario.getId_usuario())) {
			usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
			usuarioRepository.save(usuario);
		}
		
		return new ResponseEntity<Usuario>(u, HttpStatus.OK);
	}

	
	

}
