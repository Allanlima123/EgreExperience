package main.root.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CursoPos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Curso curso;
	private String local;
	private String modalidade;
	private Date ano;
	private String ch;
	
    @ManyToOne
    @JoinColumn(name = "curso_graduacao_id")
    private Curso cursoGraduacao;

	public CursoPos() {
	}

	public CursoPos(Curso curso, String local, String modalidade, Date ano, String ch, Curso cursoGraduacao) {
		this.curso = curso;
		this.local = local;
		this.modalidade = modalidade;
		this.ano = ano;
		this.ch = ch;
		this.cursoGraduacao = cursoGraduacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public Curso getCursoGraduacao() {
		return cursoGraduacao;
	}

	public void setCursoGraduacao(Curso cursoGraduacao) {
		this.cursoGraduacao = cursoGraduacao;
	}
}
