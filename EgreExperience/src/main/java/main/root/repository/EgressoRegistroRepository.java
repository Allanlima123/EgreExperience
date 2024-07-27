package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.root.model.EgressoRegistro;

@Repository
public interface EgressoRegistroRepository extends JpaRepository<EgressoRegistro, Long>{}
