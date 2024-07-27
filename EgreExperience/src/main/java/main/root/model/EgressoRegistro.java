package main.root.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EgressoRegistro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cidadeAtual;

	public EgressoRegistro() {
		super();
	}

	public EgressoRegistro(String cidadeAtual) {
		super();
		this.cidadeAtual = cidadeAtual;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCidadeAtual() {
		return cidadeAtual;
	}

	public void setCidadeAtual(String cidadeAtual) {
		this.cidadeAtual = cidadeAtual;
	}
}
