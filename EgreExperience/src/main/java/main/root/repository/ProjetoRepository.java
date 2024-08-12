package main.root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.root.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    @Query("SELECT p FROM Projeto p JOIN p.estudante e WHERE e.id = :estudanteId")
    List<Projeto> findByEstudanteId(Long estudanteId);
}
