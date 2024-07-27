package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.root.model.CursoPos;

@Repository
public interface CursoPosRepository extends JpaRepository<CursoPos, Integer>{}
