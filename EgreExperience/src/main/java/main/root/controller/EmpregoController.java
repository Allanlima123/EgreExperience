package main.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.model.Emprego;
import main.root.service.EmpregoService;

@RestController
@RequestMapping("/emprego")
public class EmpregoController {
	@Autowired
	EmpregoService empregoService;
	
	@PostMapping
	public ResponseEntity<Emprego> addEmprego(@RequestBody Emprego emprego) {
		try {
			Emprego savedEmprego = empregoService.salvarEmprego(emprego);
			return new ResponseEntity<>(savedEmprego, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
