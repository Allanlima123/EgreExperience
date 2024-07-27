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
	
    public Perfil atualizarPerfil(long id, Perfil perfilAtualizado) {
        if (!perfilRepository.existsById(id)) {
            throw new RuntimeException("Curso não encontrado com o ID: " + id);
        }

        Perfil perfilExistente = perfilRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Perfil não encontrado com o ID: " + id));

        perfilExistente.setEmail(perfilAtualizado.getEmail());
        perfilExistente.setPassword(perfilAtualizado.getPassword());

        return perfilRepository.save(perfilExistente);
    }
	
	public void deletePerfil(long id) {
		try {
			if (perfilRepository.existsById(id)) {
				perfilRepository.deleteById(id);
			} else {
				throw new RuntimeException("Curso não encontrado com o ID: " + id);
			}
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar o Curso com o ID: " + id, e);
		}
	}
}
