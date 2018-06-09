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

import com.votacion_antiv1.votacion_anti.models.Mandato;
import com.votacion_antiv1.votacion_anti.repositories.MandatoRepository;


@RestController
@RequestMapping("/api/v1/mandato")
public class MandatoController {
	
	@Autowired
	private MandatoRepository mandatoRepository;
	
	@GetMapping
	public ResponseEntity<List<Mandato>> list() {
		return new ResponseEntity<List<Mandato>>(mandatoRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mandato> get(@PathVariable("id") int id) {
		
		if(mandatoRepository.existsById(id))
			return new ResponseEntity<Mandato>(mandatoRepository.getOne(id), HttpStatus.OK);
			
		return new ResponseEntity<Mandato>(new Mandato(), HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Void> createMandato(@RequestBody Mandato mandato) {
		mandatoRepository.save(mandato);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMandato(@PathVariable("id") int id) {
		if (mandatoRepository.existsById(id))
			mandatoRepository.delete(mandatoRepository.getOne(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

	@PutMapping("/update")
	public ResponseEntity<Mandato> updateMandato(@RequestBody Mandato mandato) {
		
		Mandato m = mandatoRepository.getOne(mandato.getId_mandato());
		
		if (mandatoRepository.existsById(mandato.getId_mandato())) {
			mandatoRepository.save(mandato);
		}
		
		return new ResponseEntity<Mandato>(m, HttpStatus.OK);

	}
}
