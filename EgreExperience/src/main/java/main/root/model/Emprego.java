package main.root.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Emprego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String empresa;
	private Boolean remoto;
	private String cargo;
	private String tempo;

	@Column(length = 500)
	private String descricaoProficional;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Estudante estudante;
}
