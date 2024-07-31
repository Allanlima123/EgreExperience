package main.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Participacoes;
import main.root.repository.ParticipacoesRepository;

@Service
public class ParticipacoesService {
	@Autowired
	ParticipacoesRepository participacoesRepository;

	public List<Participacoes> buscarTodosParticipacoes() {
		try {
			return participacoesRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar todos os participacoes com participacoes", e);
		}
	}

	public Participacoes buscarPorId(long id) {
		try {
			return participacoesRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Participacoes não encontrado com o ID: " + id));
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar participacoes com o ID: " + id, e);
		}
	}

	public Participacoes salvarParticipacoes(Participacoes participacoes) {
		try {
			return participacoesRepository.save(participacoes);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o Participacoes", e);
		}
	}

	public Participacoes atualizarParticipacoes(long id, Participacoes participacoesAtualizado) {
		if (!participacoesRepository.existsById(id)) {
			throw new RuntimeException("Participacoes não encontrado com o ID: " + id);
		}

		Participacoes participacoesExistente = participacoesRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Participacoes não encontrado com o ID: " + id));

		participacoesExistente.setTipo(participacoesAtualizado.getTipo());
		participacoesExistente.setPapel(participacoesAtualizado.getPapel());
		participacoesExistente.setEstudante(participacoesAtualizado.getEstudante());
		participacoesExistente.setProjeto(participacoesAtualizado.getProjeto());

		return participacoesRepository.save(participacoesExistente);
	}

	public void deleteParticipacoes(long id) {
		try {
			if (participacoesRepository.existsById(id)) {
				participacoesRepository.deleteById(id);
			} else {
				throw new RuntimeException("Participacoes não encontrado com o ID: " + id);
			}
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar o Participacoes com o ID: " + id, e);
		}
	}
}
