package main.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Cadastro;
import main.root.repository.CadastroRepository;

@Service
public class CadastroService {
	@Autowired
	CadastroRepository cadastroRepository;
	
	public Cadastro salvarCadastro(Cadastro cadastro) {
		try {
			return cadastroRepository.save(cadastro);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o perfil", e);
		}
	}
}
