package main.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.dto.ProjetoDto;
import main.root.model.Estudante;
import main.root.model.Projeto;
import main.root.repository.EstudanteRepository;
import main.root.repository.ProjetoRepository;

@Service
public class ProjetoService {
	@Autowired
	ProjetoRepository projetoRepository;
	
	@Autowired
	private EstudanteRepository estudanteRepository;

    public List<Projeto> listarProjetos() {
        try {
            return projetoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao buscar todos os projetos com projeto", e);
        }
    }

	public Projeto buscarProjetoPorId(long id) {
		try {
			return projetoRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Projeto não encontrado com o ID: " + id));
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar projeto com o ID: " + id, e);
		}
	}
	
	public Projeto addProjeto(ProjetoDto projetoDto) {
		if (projetoDto == null) {
			throw new IllegalArgumentException("O DTO do curso não pode ser nulo.");
		}

		Projeto projeto = new Projeto();
		projeto.setNome(projetoDto.getNome());
		projeto.setDescricao(projetoDto.getDescricao());
		projeto.setAnoInicio(projetoDto.getAnoInicio());
		projeto.setAnoConclusao(projetoDto.getAnoConclusao());
		projeto.setCidadeAtual(projetoDto.getCidadeAtual());
		
		Estudante estudante = estudanteRepository.findById(projetoDto.getEstudanteId()).orElseThrow(
				() -> new RuntimeException("Estudante com ID " + projetoDto.getEstudanteId() + " não encontrado."));

		projeto.setEstudante(estudante);

		try {
			return projetoRepository.save(projeto);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o Curso", e);
		}
	}
	
    public List<Projeto> buscarProjetosPorEstudante(Long estudanteId) {
        return projetoRepository.findByEstudanteId(estudanteId);
    }


//    public Projeto atualizarProjeto(long id, Projeto projetoAtualizado) {
//        if (!projetoRepository.existsById(id)) {
//            throw new RuntimeException("Projeto não encontrado com o ID: " + id);
//        }
//
//        Projeto projetoExistente = projetoRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Projeto não encontrado com o ID: " + id));
//
//        projetoExistente.setNome(projetoAtualizado.getNome());
//        projetoExistente.setModalidade(projetoAtualizado.getModalidade());
//        projetoExistente.setAnoInicio(projetoAtualizado.getAnoInicio());
//        projetoExistente.setAnoConclusao(projetoAtualizado.getAnoConclusao());
//        projetoExistente.setCh(projetoAtualizado.getCh());
//
//        return projetoRepository.save(projetoExistente);
//    }
//	
	public void deleteProjeto(long id) {
		try {
			if (projetoRepository.existsById(id)) {
				projetoRepository.deleteById(id);
			} else {
				throw new RuntimeException("Projeto não encontrado com o ID: " + id);
			}
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar o Projeto com o ID: " + id, e);
		}
	}
}
