package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.root.model.Habilidade;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {

}