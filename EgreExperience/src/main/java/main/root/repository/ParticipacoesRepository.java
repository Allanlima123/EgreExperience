package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.root.model.Participacoes;

public interface ParticipacoesRepository extends JpaRepository<Participacoes, Long>{}
