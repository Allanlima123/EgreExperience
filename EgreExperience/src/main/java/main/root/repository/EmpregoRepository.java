package main.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.root.model.Emprego;

public interface EmpregoRepository extends JpaRepository<Emprego, Long>{}
