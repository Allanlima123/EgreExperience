package main.root.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
public class Participacoes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String tipo;
	private String papel;

	@ManyToOne
	@JoinColumn(name = "emprego_id")
	private Emprego emprego;

	@ManyToOne
	@JoinColumn(name = "estudante_id")
	private Estudante estudante;

	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;

	public Participacoes() {
		super();
	}

	public Participacoes(String tipo, String papel, Emprego emprego, Estudante estudante, Projeto projeto) {
		super();
		this.tipo = tipo;
		this.papel = papel;
		this.emprego = emprego;
		this.estudante = estudante;
		this.projeto = projeto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public Emprego getEmprego() {
		return emprego;
	}

	public void setEmprego(Emprego emprego) {
		this.emprego = emprego;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
