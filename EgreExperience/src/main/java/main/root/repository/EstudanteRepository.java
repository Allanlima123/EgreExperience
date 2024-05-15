package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.root.model.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long>{}
