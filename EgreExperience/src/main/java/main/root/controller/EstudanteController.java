package main.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.model.Estudante;
import main.root.service.EstudanteService;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {
	@Autowired
	EstudanteService estudanteService;
	
	@PostMapping
	public ResponseEntity<Estudante> addEstudante(@RequestBody Estudante estudante) {
		try {
			Estudante savedEstudante = estudanteService.salvarEstudante(estudante);
			return new ResponseEntity<>(savedEstudante, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
