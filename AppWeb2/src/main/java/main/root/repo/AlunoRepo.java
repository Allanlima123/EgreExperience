package main.root.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import main.root.basica.Aluno;


public interface AlunoRepo extends JpaRepository<Aluno, Integer> {}
