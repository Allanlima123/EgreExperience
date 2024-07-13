package main.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.model.Cadastro;
import main.root.service.CadastroService;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {
	@Autowired
	CadastroService cadastroService;
	
	@PostMapping
	public ResponseEntity<Cadastro> addCadastro(@RequestBody Cadastro cadastro) {
		try {
			Cadastro savedCadastro = cadastroService.salvarCadastro(cadastro);
			return new ResponseEntity<>(savedCadastro, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
