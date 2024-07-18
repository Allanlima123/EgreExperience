package main.root.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String descricao;
	
	private Date anoInicio;
	private Date anoConclusao;
	
	private String cidadeAtual;
	
    @ManyToMany(mappedBy = "projetos")
    private List<Estudante> estudantes;
	
    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;
}
