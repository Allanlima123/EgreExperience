package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.root.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long>{}
