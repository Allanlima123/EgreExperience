package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.root.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{}
