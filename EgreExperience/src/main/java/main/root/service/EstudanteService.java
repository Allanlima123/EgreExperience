package main.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.root.model.Estudante;
import main.root.repository.EstudanteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {
    @Autowired
    EstudanteRepository estudanteRepository;

    public Estudante salvarEstudante(Estudante estudante) {
        try {
            return estudanteRepository.save(estudante);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao salvar o estudante", e);
        }
    }

    public List<Estudante> obterTodosEstudantes() {
        try {
            return estudanteRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao obter todos os estudantes", e);
        }
    }

    public Optional<Estudante> obterEstudantePorId(Long id) {
        try {
            return estudanteRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao obter o estudante pelo ID", e);
        }
    }

//    public Estudante atualizarEstudante(Long id, Estudante estudanteAtualizado) {
//        try {
//            Estudante estudanteExistente = estudanteRepository.findById(id)
//                    .orElseThrow(() -> new RuntimeException("Estudante não encontrado"));
//            estudanteExistente.setNome(estudanteAtualizado.g);
//            estudanteExistente.setEmail(estudanteAtualizado.getEmail());
//            estudanteExistente.setCurso(estudanteAtualizado.getCurso());
//            return estudanteRepository.save(estudanteExistente);
//        } catch (Exception e) {
//            throw new RuntimeException("Falha ao atualizar o estudante", e);
//        }
//    }

    public void deletarEstudante(Long id) {
        try {
            estudanteRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao deletar o estudante", e);
        }
    }
}
