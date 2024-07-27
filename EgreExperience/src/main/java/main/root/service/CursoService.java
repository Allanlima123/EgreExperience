package main.root.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Curso;
import main.root.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;

    public List<Curso> buscarTodosCursos() {
        try {
            return cursoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao buscar todos os cursos com curso", e);
        }
    }

	public Curso buscarPorId(long id) {
		try {
			return cursoRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + id));
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar curso com o ID: " + id, e);
		}
	}

	public Curso salvarCurso(Curso curso) {
		try {
			return cursoRepository.save(curso);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o Curso", e);
		}
	}

    public Curso atualizarCurso(long id, Curso cursoAtualizado) {
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso não encontrado com o ID: " + id);
        }

        Curso cursoExistente = cursoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + id));

        cursoExistente.setNome(cursoAtualizado.getNome());
        cursoExistente.setModalidade(cursoAtualizado.getModalidade());
        cursoExistente.setAnoInicio(cursoAtualizado.getAnoInicio());
        cursoExistente.setAnoConclusao(cursoAtualizado.getAnoConclusao());

        return cursoRepository.save(cursoExistente);
    }
	
	public void deleteCurso(long id) {
		try {
			if (cursoRepository.existsById(id)) {
				cursoRepository.deleteById(id);
			} else {
				throw new RuntimeException("Curso não encontrado com o ID: " + id);
			}
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar o Curso com o ID: " + id, e);
		}
	}
}
