package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.root.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {}
