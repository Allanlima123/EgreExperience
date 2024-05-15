package main.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Perfil;
import main.root.repository.PerfilRepository;


@Service
public class PerfilService {
	
	@Autowired
	PerfilRepository perfilRepository;

	public Perfil salvarPerfil(Perfil perfil) {
		try {
			return perfilRepository.save(perfil);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o perfil", e);
		}
	}
}
