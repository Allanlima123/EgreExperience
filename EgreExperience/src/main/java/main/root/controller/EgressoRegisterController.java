package main.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.model.EgressoRegistro;
import main.root.service.EgressoRegistroService;

@RestController
@RequestMapping("egressoRegistro")
public class EgressoRegisterController {
	@Autowired
	EgressoRegistroService egressoRegistroService;
	
	@PostMapping
	public ResponseEntity<EgressoRegistro> addCadastro(@RequestBody EgressoRegistro egressoRegistro) {
		try {
			EgressoRegistro salvarEgressoRegistro = egressoRegistroService.salvarEgressoRegistro(egressoRegistro);
			return new ResponseEntity<>(salvarEgressoRegistro, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
