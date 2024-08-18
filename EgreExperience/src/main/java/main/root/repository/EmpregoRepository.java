package main.root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.root.model.Emprego;

@Repository
public interface EmpregoRepository extends JpaRepository<Emprego, Long> {
	@Query("SELECT emp FROM Emprego emp JOIN emp.estudante e WHERE e.id = :estudanteId")
	List<Emprego> findByEstudanteId(Long estudanteId);


}
