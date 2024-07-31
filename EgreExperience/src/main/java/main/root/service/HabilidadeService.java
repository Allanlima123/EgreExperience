package main.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Habilidade;
import main.root.repository.HabilidadeRepository;

@Service
public class HabilidadeService {
	@Autowired
	HabilidadeRepository habilidadeRepository;

	public List<Habilidade> buscarTodosHabilidades() {
		try {
			return habilidadeRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar todos os habilidades com habilidade", e);
		}
	}

	public Habilidade buscarPorId(long id) {
		try {
			return habilidadeRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Habilidade não encontrado com o ID: " + id));
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar habilidade com o ID: " + id, e);
		}
	}

	public Habilidade salvarHabilidade(Habilidade habilidade) {
		try {
			return habilidadeRepository.save(habilidade);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o Habilidade", e);
		}
	}

	public Habilidade atualizarHabilidade(long id, Habilidade habilidadeAtualizado) {
		if (!habilidadeRepository.existsById(id)) {
			throw new RuntimeException("Habilidade não encontrado com o ID: " + id);
		}

		Habilidade habilidadeExistente = habilidadeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Habilidade não encontrado com o ID: " + id));

		habilidadeExistente.setNome(habilidadeAtualizado.getNome());
		habilidadeExistente.setDescricaoTecnica(habilidadeAtualizado.getDescricaoTecnica());
		habilidadeExistente.setNivel(habilidadeAtualizado.getNivel());

		return habilidadeRepository.save(habilidadeExistente);
	}

	public void deleteHabilidade(long id) {
		try {
			if (habilidadeRepository.existsById(id)) {
				habilidadeRepository.deleteById(id);
			} else {
				throw new RuntimeException("Habilidade não encontrado com o ID: " + id);
			}
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar o Habilidade com o ID: " + id, e);
		}
	}
}
