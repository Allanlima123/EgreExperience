package main.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.CursoPos;
import main.root.repository.CursoPosRepository;

@Service
public class CursoPosService {
	@Autowired
	CursoPosRepository cursoPosRepository;
	
	public CursoPos salvarCursoPos(CursoPos cursoPos) {
		try {
			return cursoPosRepository.save(cursoPos);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o CursoPos", e);
		}
	}
	
    public CursoPos atualizarCursoPos(int id, CursoPos cursoPosAtualizado) {
        if (!cursoPosRepository.existsById(id)) {
            throw new RuntimeException("Curso não encontrado com o ID: " + id);
        }

        CursoPos cursoPosExistente = cursoPosRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("CursoPos não encontrado com o ID: " + id));

        cursoPosExistente.setLocal(cursoPosAtualizado.getLocal());
        cursoPosExistente.setModalidade(cursoPosAtualizado.getModalidade());
        cursoPosExistente.setAnoInicio(cursoPosAtualizado.getAnoInicio());
        cursoPosExistente.setAnoConclusao(cursoPosAtualizado.getAnoConclusao());
        cursoPosExistente.setCh(cursoPosAtualizado.getCh());
        cursoPosExistente.setCurso(cursoPosAtualizado.getCurso());

        return cursoPosRepository.save(cursoPosExistente);
    }
	
	public void deletePosCurso(int id) {
		try {
			if (cursoPosRepository.existsById(id)) {
				cursoPosRepository.deleteById(id);
			} else {
				throw new RuntimeException("CursoPos não encontrado com o ID: " + id);
			}
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar o CursoPos com o ID: " + id, e);
		}
	}
}
