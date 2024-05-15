package main.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.model.Curso;
import main.root.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	CursoService cursoService;
	
	@PostMapping
	public ResponseEntity<Curso> addCurso(@RequestBody Curso curso) {
		try {
			Curso savedCurso = cursoService.salvarCurso(curso);
			return new ResponseEntity<>(savedCurso, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
