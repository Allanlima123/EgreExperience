package main.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.dto.PerfilDto;
import main.root.model.Perfil;
import main.root.repository.PerfilRepository;

@Service
public class PerfilService {
	@Autowired
	PerfilRepository perfilRepository;

	public List<Perfil> listarPerfils() {
		try {
			return perfilRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar todos os perfils com perfil", e);
		}
	}

	public Perfil buscarPerfilPorId(long id) {
		try {
			return perfilRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Perfil não encontrado com o ID: " + id));
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar perfil com o ID: " + id, e);
		}
	}

	public Perfil addPerfil(PerfilDto perfilDto) {
		if (perfilDto == null) {
			throw new IllegalArgumentException("O DTO do curso não pode ser nulo.");
		}

		Perfil perfil = new Perfil();
		perfil.setEmail(perfilDto.getEmail());
		perfil.setPassword(perfilDto.getPassword());

		try {
			return perfilRepository.save(perfil);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o Perfil", e);
		}
	}

	public Perfil atualizarPerfil(long id, PerfilDto perfilDto) {
		if (!perfilRepository.existsById(id)) {
			throw new RuntimeException("Perfil não encontrado com o ID: " + id);
		}

		Perfil perfilExistente = perfilRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Perfil não encontrado com o ID: " + id));

		perfilExistente.setEmail(perfilDto.getEmail());
		perfilExistente.setPassword(perfilDto.getPassword());

		return perfilRepository.save(perfilExistente);
	}

	public void deletePerfil(Long id) {
		try {
			if (perfilRepository.existsById(id)) {
				perfilRepository.deleteById(id);
			} else {
				throw new RuntimeException("Perfil não encontrado com o ID: " + id);
			}
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar o Perfil com o ID: " + id, e);
		}
	}
}
