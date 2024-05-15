package main.root.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.model.Perfil;
import main.root.service.PerfilService;


@RestController
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	PerfilService perfilService;
	
	@PostMapping
	public ResponseEntity<Perfil> addPerfil(@RequestBody Perfil perfil) {
		try {
			Perfil savedPerfil = perfilService.salvarPerfil(perfil);
			return new ResponseEntity<>(savedPerfil, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
