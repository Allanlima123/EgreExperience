package main.root.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Emprego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String empresa;
	private Boolean remoto;
	private String cargo;
	private String tempo;
	
    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;
    
    @OneToMany(mappedBy = "emprego", cascade = CascadeType.ALL)
    private List<Participacoes> participacoes = new ArrayList<>();

	public Emprego() {
	}

	public Emprego(String empresa, Boolean remoto, String cargo, String tempo, Estudante estudante,
			List<Participacoes> participacoes) {
		this.empresa = empresa;
		this.remoto = remoto;
		this.cargo = cargo;
		this.tempo = tempo;
		this.estudante = estudante;
		this.participacoes = participacoes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Boolean getRemoto() {
		return remoto;
	}

	public void setRemoto(Boolean remoto) {
		this.remoto = remoto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public List<Participacoes> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacoes> participacoes) {
		this.participacoes = participacoes;
	}
}
