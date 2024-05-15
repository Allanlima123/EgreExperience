package main.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Emprego;
import main.root.repository.EmpregoRepository;

@Service
public class EmpregoService {
	@Autowired
	EmpregoRepository EmpregoRepository;
	
	public Emprego salvarEmprego(Emprego emprego) {
		try {
			return EmpregoRepository.save(emprego);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o perfil", e);
		}
	}
}
