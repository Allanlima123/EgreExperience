package main.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.model.Projeto;
import main.root.service.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
	@Autowired
	ProjetoService projetoService;
	
	@PostMapping
	public ResponseEntity<Projeto> addProjeto(@RequestBody Projeto projeto) {
		try {
			Projeto savedProjeto = projetoService.salvarProjeto(projeto);
			return new ResponseEntity<>(savedProjeto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
