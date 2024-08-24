package main.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.dto.EstudanteDto;
import main.root.model.Estudante;
import main.root.model.Perfil;
import main.root.repository.EstudanteRepository;
import main.root.repository.PerfilRepository;

@Service
public class EstudanteService {
	@Autowired
	EstudanteRepository estudanteRepository;
	
	@Autowired
	PerfilRepository perfilRepository;

	public List<Estudante> listarEstudantes() {
		try {
			return estudanteRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar todos os estudantes com estudante", e);
		}
	}

	public Estudante buscarEstudantePorId(long id) {
		try {
			return estudanteRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Estudante não encontrado com o ID: " + id));
		} catch (Exception e) {
			throw new RuntimeException("Falha ao buscar estudante com o ID: " + id, e);
		}
	}

	public Estudante addEstudante(EstudanteDto estudanteDto) {
	    if (estudanteDto == null) {
	        throw new IllegalArgumentException("O DTO do Estudante não pode ser nulo.");
	    }

	    Perfil perfil = perfilRepository.findById(estudanteDto.getPerfilId())
	            .orElseThrow(() -> new RuntimeException("Perfil com ID " + estudanteDto.getPerfilId() + " não encontrado."));

	    Estudante estudante = new Estudante();
	    estudante.setAnoFormacao(estudanteDto.getAnoFormacao());
	    estudante.setFoto(estudanteDto.getFoto());
	    estudante.setNome(estudanteDto.getNome());
	    estudante.setDescricaoTecnica(estudanteDto.getDescricaoTecnica());
	    estudante.setCargoAtual(estudanteDto.getCargoAtual());
	    estudante.setIdiomas(estudanteDto.getIdiomas());
	    estudante.setHabilidades(estudanteDto.getHabilidades());
	    estudante.setPerfil(perfil);

	    try {
	        return estudanteRepository.save(estudante);
	    } catch (Exception e) {
	        throw new RuntimeException("Falha ao salvar o Estudante", e);
	    }
	}


}
