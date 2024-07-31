package main.root.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Participacoes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String tipo;
	private String papel;

	@ManyToOne
	private Estudante estudante;

	@ManyToOne
	private Projeto projeto;
	
	
	//OBS: participacoes estar com problema
}
