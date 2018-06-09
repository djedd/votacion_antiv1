package com.votacion_antiv1.votacion_anti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votacion_antiv1.votacion_anti.models.Voto;
import com.votacion_antiv1.votacion_anti.repositories.VotoRepository;




@RestController
@RequestMapping("/api/v1/voto")
public class VotoController {
	
	@Autowired
	VotoRepository votoRepository;
	
	@PostMapping("/save")
	public void createVoto(@RequestBody Voto voto) {
		votoRepository.save(voto);
	}
	
	@GetMapping
	public ResponseEntity<List<Voto>> getVotos() {
		return new ResponseEntity<List<Voto>>(votoRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Integer> getUsuarioVoto(@PathVariable("id") int id) {		
		return new ResponseEntity<Integer>(votoRepository.numVotosJugador(id), HttpStatus.OK);
	}

}
