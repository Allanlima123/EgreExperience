package main.root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import main.root.model.Participacoes;

public interface ParticipacoesRepository extends JpaRepository<Participacoes, Long>{
	@Query("SELECT par FROM Participacoes par JOIN par.projeto pro WHERE pro.id = :projetoId")
	List<Participacoes> findByProjetoId(Long projetoId);
}
