package main.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Estudante;
import main.root.repository.EstudanteRepository;

@Service
public class EstudanteService {
	@Autowired
	EstudanteRepository EstudanteRepository;
	
	public Estudante salvarEstudante(Estudante estudante) {
		try {
			return EstudanteRepository.save(estudante);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o perfil", e);
		}
	}
}
