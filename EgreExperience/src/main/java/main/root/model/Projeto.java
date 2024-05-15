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
	private Projeto projetos;
	
    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;
    
    @OneToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

	public Projeto() {
	}

	public Projeto(Date anoConclusao, String cidadeAtual, Projeto projetos, Estudante estudante, Curso curso) {
		this.anoConclusao = anoConclusao;
		this.cidadeAtual = cidadeAtual;
		this.projetos = projetos;
		this.estudante = estudante;
		this.curso = curso;
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

	public Projeto getProjetos() {
		return projetos;
	}

	public void setProjetos(Projeto projetos) {
		this.projetos = projetos;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
