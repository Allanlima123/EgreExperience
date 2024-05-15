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
import jakarta.persistence.OneToOne;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String modalidade;
	
    @OneToOne(mappedBy = "curso", cascade = CascadeType.ALL)
    private Estudante estudante;
    
    @OneToOne(mappedBy = "curso")
    private Projeto projeto;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<CursoPos> cursosPos = new ArrayList<>();

	public Curso() {
	}

	public Curso(String nome, String modalidade, Estudante estudante, Projeto projeto, List<CursoPos> cursosPos) {
		this.nome = nome;
		this.modalidade = modalidade;
		this.estudante = estudante;
		this.projeto = projeto;
		this.cursosPos = cursosPos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
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

	public List<CursoPos> getCursosPos() {
		return cursosPos;
	}

	public void setCursosPos(List<CursoPos> cursosPos) {
		this.cursosPos = cursosPos;
	}
}
