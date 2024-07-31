package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.root.model.Habilidade;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {

}