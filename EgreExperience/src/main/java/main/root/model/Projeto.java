package main.root.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Date anoConclusao;
	private String cidadeAtual;
	
    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;


	public Projeto() {
	}

	public Projeto(Date anoConclusao, String cidadeAtual, Projeto projetos) {
		this.anoConclusao = anoConclusao;
		this.cidadeAtual = cidadeAtual;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(Date anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public String getCidadeAtual() {
		return cidadeAtual;
	}

	public void setCidadeAtual(String cidadeAtual) {
		this.cidadeAtual = cidadeAtual;
	}


	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

}
