package main.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.dto.EmpregoDto;
import main.root.model.Emprego;
import main.root.model.Estudante;
import main.root.repository.EmpregoRepository;
import main.root.repository.EstudanteRepository;

@Service
public class EmpregoService {
	@Autowired
	EmpregoRepository empregoRepository;
	
	@Autowired
	EstudanteRepository estudanteRepository;

	public List<Emprego> listarEmpregos() {
		try {
			return empregoRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar todos os empregos com emprego", e);
		}
	}

	public Emprego buscarEmpregoPorId(long id) {
		try {
			return empregoRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Emprego não encontrado com o ID: " + id));
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar emprego com o ID: " + id, e);
		}
	}

	public Emprego addEmprego(EmpregoDto empregoDto) {
		if (empregoDto == null) {
			throw new IllegalArgumentException("O DTO do emprego não pode ser nulo.");
		}

		Emprego emprego = new Emprego();
		emprego.setEmpresa(empregoDto.getEmpresa());
		emprego.setRemoto(empregoDto.getRemoto());
		emprego.setCargo(empregoDto.getCargo());
		emprego.setTempo(empregoDto.getTempo());
		emprego.setDescricaoProficional(empregoDto.getDescricaoProficional());

		Estudante estudante = estudanteRepository.findById(empregoDto.getEstudanteId()).orElseThrow(
				() -> new RuntimeException("Estudante com ID " + empregoDto.getEstudanteId() + " não encontrado."));

		emprego.setEstudante(estudante);

		try {
			return empregoRepository.save(emprego);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o Emprego", e);
		}
	}
	
	public List<Emprego> buscarEmpregosPorEstudante(Long estudanteId) {
		return empregoRepository.findByEstudanteId(estudanteId);
	}

//    public Emprego atualizarEmprego(long id, Emprego empregoAtualizado) {
//        if (!empregoRepository.existsById(id)) {
//            throw new RuntimeException("Emprego não encontrado com o ID: " + id);
//        }
//
//        Emprego empregoExistente = empregoRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Emprego não encontrado com o ID: " + id));
//
//        empregoExistente.setNome(empregoAtualizado.getNome());
//        empregoExistente.setModalidade(empregoAtualizado.getModalidade());
//        empregoExistente.setAnoInicio(empregoAtualizado.getAnoInicio());
//        empregoExistente.setAnoConclusao(empregoAtualizado.getAnoConclusao());
//        empregoExistente.setCh(empregoAtualizado.getCh());
//
//        return empregoRepository.save(empregoExistente);
//    }
//	
	public void deleteEmprego(Long id) {
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
