package main.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.EgressoRegistro;
import main.root.repository.EgressoRegistroRepository;

@Service
public class EgressoRegistroService {
	@Autowired
	EgressoRegistroRepository egressoRegistroRepository;
	
	public EgressoRegistro salvarEgressoRegistro(EgressoRegistro egressoRegistro) {
		try {
			return egressoRegistroRepository.save(egressoRegistro);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o perfil", e);
		}
	}
}
