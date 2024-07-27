package main.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Projeto;
import main.root.repository.ProjetoRepository;

@Service
public class ProjetoService {
	@Autowired
	ProjetoRepository projetoRepository;
	
	public Projeto salvarProjeto(Projeto projeto) {
		try {
			return projetoRepository.save(projeto);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o Projeto", e);
		}
	}
	
    public List<Projeto> buscarTodosProjetos() {
        try {
            return projetoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao buscar todos Projetos", e);
        }
    }
    
    public Projeto atualizarProjeto(long id, Projeto projetoAtualizado) {
        if (!projetoRepository.existsById(id)) {
            throw new RuntimeException("Curso não encontrado com o ID: " + id);
        }

        Projeto projetoExistente = projetoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado com o ID: " + id));

        projetoExistente.setNome(projetoAtualizado.getNome());
        projetoExistente.setDescricao(projetoAtualizado.getDescricao());
        projetoExistente.setAnoInicio(projetoAtualizado.getAnoInicio());
        projetoExistente.setAnoConclusao(projetoAtualizado.getAnoConclusao());
        projetoExistente.setCidadeAtual(projetoAtualizado.getCidadeAtual());
        projetoExistente.setEstudante(projetoAtualizado.getEstudante());

        return projetoRepository.save(projetoExistente);
    }
	
	public void deleteProjeto(long id) {
		try {
			if (projetoRepository.existsById(id)) {
				projetoRepository.deleteById(id);
			} else {
				throw new RuntimeException("Curso não encontrado com o ID: " + id);
			}
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar o Curso com o ID: " + id, e);
		}
	}

}
