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
			throw new RuntimeException("Falha ao salvar o perfil", e);
		}
	}
}
