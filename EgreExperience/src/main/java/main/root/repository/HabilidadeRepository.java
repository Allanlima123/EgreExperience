package main.root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import main.root.model.Habilidade;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
	@Query("SELECT a FROM Habilidade a JOIN a.estudante e WHERE e.id = :estudanteId")
	List<Habilidade> findByEstudanteId(Long estudanteId);
}