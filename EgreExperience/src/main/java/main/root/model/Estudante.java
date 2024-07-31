package main.root.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Estudante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date anoFormacao;

	private String foto;
	private String nome;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Idioma> idiomas;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Habilidade> habilidades;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Emprego> empregos;

	@ManyToOne
	private Perfil perfil;

	@OneToMany
	private List<Curso> cursos;

}
