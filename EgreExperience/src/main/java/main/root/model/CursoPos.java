package main.root.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class CursoPos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String local;
	private String modalidade;
	private Date anoInicio;
	private Date anoConclusao;
	private String ch;
	
    @ManyToOne
    @JoinColumn(name = "curso_graduacao_id")
    private Curso cursoGraduacao;
}
