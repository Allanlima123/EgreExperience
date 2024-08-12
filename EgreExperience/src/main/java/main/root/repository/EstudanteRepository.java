package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.root.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
//	List<Projeto> findAllProjetosById(Long estudanteId);
}
