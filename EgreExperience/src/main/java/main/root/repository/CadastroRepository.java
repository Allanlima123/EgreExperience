package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.root.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long>{}
