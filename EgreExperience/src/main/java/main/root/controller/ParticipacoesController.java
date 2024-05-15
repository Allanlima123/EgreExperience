package main.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.model.Participacoes;
import main.root.service.ParticipacoesService;

@RestController
@RequestMapping("/participacoes")
public class ParticipacoesController {
	@Autowired
	ParticipacoesService participacoesService;
	
	@PostMapping
	public ResponseEntity<Participacoes> addCadastro(@RequestBody Participacoes participacoes) {
		try {
			Participacoes savedparticipacoes = participacoesService.salvarParticipacoes(participacoes);
			return new ResponseEntity<>(savedparticipacoes, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
