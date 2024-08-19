package main.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.dto.CursoDto;
import main.root.model.Curso;
import main.root.model.Estudante;
import main.root.repository.CursoRepository;
import main.root.repository.EstudanteRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;

	@Autowired
	private EstudanteRepository estudanteRepository;

	public List<Curso> listarCursos() {
		try {
			return cursoRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar todos os cursos com curso", e);
		}
	}

	public Curso buscarCursoPorId(long id) {
		try {
			return cursoRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + id));
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar curso com o ID: " + id, e);
		}
	}

	public Curso addCurso(CursoDto cursoDto) {
		if (cursoDto == null) {
			throw new IllegalArgumentException("O DTO do curso não pode ser nulo.");
		}

		Curso curso = new Curso();
		curso.setNome(cursoDto.getNome());
		curso.setUniversidade(cursoDto.getUniversidade());
		curso.setModalidade(cursoDto.getModalidade());
		curso.setAnoInicio(cursoDto.getAnoInicio());
		curso.setAnoConclusao(cursoDto.getAnoConclusao());
		curso.setCh(cursoDto.getCh());

		Estudante estudante = estudanteRepository.findById(cursoDto.getEstudanteId()).orElseThrow(
				() -> new RuntimeException("Estudante com ID " + cursoDto.getEstudanteId() + " não encontrado."));

		curso.setEstudante(estudante);

		try {
			return cursoRepository.save(curso);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o Curso", e);
		}
	}

	public List<Curso> buscarCursosPorEstudante(Long estudanteId) {
		return cursoRepository.findByEstudanteId(estudanteId);
	}

//    public Curso atualizarCurso(long id, Curso cursoAtualizado) {
//        if (!cursoRepository.existsById(id)) {
//            throw new RuntimeException("Curso não encontrado com o ID: " + id);
//        }
//
//        Curso cursoExistente = cursoRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + id));
//
//        cursoExistente.setNome(cursoAtualizado.getNome());
//        cursoExistente.setModalidade(cursoAtualizado.getModalidade());
//        cursoExistente.setAnoInicio(cursoAtualizado.getAnoInicio());
//        cursoExistente.setAnoConclusao(cursoAtualizado.getAnoConclusao());
//        cursoExistente.setCh(cursoAtualizado.getCh());
//
//        return cursoRepository.save(cursoExistente);
//    }
//	
	public void deleteCurso(Long id) {
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
