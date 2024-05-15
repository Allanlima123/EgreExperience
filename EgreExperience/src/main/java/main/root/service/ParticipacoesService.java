package main.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Participacoes;
import main.root.repository.ParticipacoesRepository;

@Service
public class ParticipacoesService {
	@Autowired
	ParticipacoesRepository participacoesRepository;
	
	public Participacoes salvarParticipacoes(Participacoes participacoes) {
		try {
			return participacoesRepository.save(participacoes);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o perfil", e);
		}
	}
}
