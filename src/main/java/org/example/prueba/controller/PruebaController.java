package org.example.prueba.controller;

import org.example.prueba.model.Prueba;
import org.example.prueba.repository.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/prueba")
public class PruebaController {
	
	@Autowired
	private PruebaRepository pruebaRepository;
	
	@PostMapping
	public Mono<Prueba> insert(){
		Prueba prueba=new Prueba();
		prueba.setNombre("Percy");
		prueba.setApellido("Paul");
		return pruebaRepository.insert(prueba);
	}
}
