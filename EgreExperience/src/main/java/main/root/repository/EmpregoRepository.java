package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.root.model.Emprego;

@Repository
public interface EmpregoRepository extends JpaRepository<Emprego, Long>{}
