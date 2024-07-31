package main.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Emprego;
import main.root.repository.EmpregoRepository;

@Service
public class EmpregoService {
	@Autowired
	EmpregoRepository empregoRepository;
	
    public List<Emprego> buscarTodosempregos() {
        try {
            return empregoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao buscar todos os empregos com emprego", e);
        }
    }

	public Emprego salvarEmprego(Emprego emprego) {
		try {
			return empregoRepository.save(emprego);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o perfil", e);
		}
	}

	public Emprego atualizarEmprego(long id, Emprego empregoAtualizado) {
		if (!empregoRepository.existsById(id)) {
			throw new RuntimeException("Emprego não encontrado com o ID: " + id);
		}

		Emprego empregoExistente = empregoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Emprego não encontrado com o ID: " + id));

		empregoExistente.setEmpresa(empregoAtualizado.getEmpresa());
		empregoExistente.setRemoto(empregoAtualizado.getRemoto());
		empregoExistente.setCargo(empregoAtualizado.getCargo());
		empregoExistente.setTempo(empregoAtualizado.getTempo());
		empregoExistente.setDescricaoProficional(empregoAtualizado.getDescricaoProficional());

		return empregoRepository.save(empregoExistente);
	}

	public void deleteEmprego(long id) {
		try {
			if (empregoRepository.existsById(id)) {
				empregoRepository.deleteById(id);
			} else {
				throw new RuntimeException("Emprego não encontrado com o ID: " + id);
			}
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar o Emprego com o ID: " + id, e);
		}
	}
}
