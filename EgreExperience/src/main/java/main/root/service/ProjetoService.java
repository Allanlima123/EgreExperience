package main.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Projeto;
import main.root.repository.ProjetoRepository;

@Service
public class ProjetoService {
	@Autowired
	ProjetoRepository projetoRepository;
	
	public Projeto salvarProjeto(Projeto projeto) {
		try {
			return projetoRepository.save(projeto);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o perfil", e);
		}
	}

}
