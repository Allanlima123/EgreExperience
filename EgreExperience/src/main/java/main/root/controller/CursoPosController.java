package main.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.model.CursoPos;
import main.root.service.CursoPosService;

@RestController
@RequestMapping("/curso_pos")
public class CursoPosController {
	@Autowired
	CursoPosService cursoPosService;
	
	@PostMapping
	public ResponseEntity<CursoPos> addCursoPos(@RequestBody CursoPos cursoPos) {
		try {
			CursoPos savedCursoPos = cursoPosService.salvarCursoPos(cursoPos);
			return new ResponseEntity<>(savedCursoPos, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
