package main.root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.root.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	@Query("SELECT c FROM Curso c JOIN c.estudante e WHERE e.id = :estudanteId")
	List<Curso> findByEstudanteId(Long estudanteId);
}
