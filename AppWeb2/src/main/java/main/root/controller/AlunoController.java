package main.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.basica.Aluno;
import main.root.repo.AlunoRepo;


@RestController
@RequestMapping("aluno")
public class AlunoController {
	@Autowired
	private AlunoRepo repo;
	
	@PostMapping
	public Aluno add(@RequestBody Aluno aluno) {
		return repo.save(aluno);
	}
	
	@GetMapping
	public List<Aluno> listar() {
		return repo.findAll();
	}
}
