package main.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.dto.ParticipacoesDto;
import main.root.model.Participacoes;
import main.root.model.Projeto;
import main.root.repository.ParticipacoesRepository;
import main.root.repository.ProjetoRepository;

@Service
public class ParticipacoesService {
	@Autowired
	ParticipacoesRepository participacoesRepository;

	@Autowired
	ProjetoRepository projetoRepository;

	public List<Participacoes> listarParticipacoess() {
		try {
			return participacoesRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar todos os participacoess com participacoes", e);
		}
	}

	public Participacoes buscarParticipacoesPorId(long id) {
		try {
			return participacoesRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Participacoes não encontrado com o ID: " + id));
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar participacoes com o ID: " + id, e);
		}
	}

	public Participacoes addParticipacoes(ParticipacoesDto participacoesDto) {
		if (participacoesDto == null) {
			throw new IllegalArgumentException("O DTO do curso não pode ser nulo.");
		}

		Participacoes participacoes = new Participacoes();

		participacoes.setNome(participacoesDto.getNome());
		participacoes.setPapel(participacoesDto.getPapel());
		participacoes.setNivel(participacoesDto.getNivel());

		Projeto projeto = projetoRepository.findById(participacoesDto.getProjetoId()).orElseThrow(
				() -> new RuntimeException("Estudante com ID " + participacoesDto.getProjetoId() + " não encontrado."));

		participacoes.setProjeto(projeto);

		try {
			return participacoesRepository.save(participacoes);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o Participacoes", e);
		}
	}

	public List<Participacoes> buscarParticipacoesPorProjetoId(Long projetoId) {
		return participacoesRepository.findByProjetoId(projetoId);
	}

//    public Participacoes atualizarParticipacoes(long id, Participacoes participacoesAtualizado) {
//        if (!participacoesRepository.existsById(id)) {
//            throw new RuntimeException("Participacoes não encontrado com o ID: " + id);
//        }
//
//        Participacoes participacoesExistente = participacoesRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Participacoes não encontrado com o ID: " + id));
//
//        participacoesExistente.setNome(participacoesAtualizado.getNome());
//        participacoesExistente.setModalidade(participacoesAtualizado.getModalidade());
//        participacoesExistente.setAnoInicio(participacoesAtualizado.getAnoInicio());
//        participacoesExistente.setAnoConclusao(participacoesAtualizado.getAnoConclusao());
//        participacoesExistente.setCh(participacoesAtualizado.getCh());
//
//        return participacoesRepository.save(participacoesExistente);
//    }
//	
	public void deletarParticipacoes(Long id) {
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
