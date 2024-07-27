package main.root.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Estudante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date anoFormacao;

	private String foto;
	private String nome;

	@JoinColumn(name = "perfil_id")
	@ManyToOne
	private Perfil perfil;

	@JoinColumn(name = "cadastro_id")
	@ManyToOne
	private EgressoRegistro egressoRegistro;

	@ManyToMany
	@JoinTable(name = "participacao", 
	joinColumns = @JoinColumn(name = "estudante_id"), 
	inverseJoinColumns = @JoinColumn(name = "projeto_id"))
	private List<Projeto> projetos;

	@JoinColumn(name = "curso_id")
	@ManyToOne
	private Curso curso;

	public Estudante() {
		super();
	}

	public Estudante(Date anoFormacao, String foto, String nome, Perfil perfil, EgressoRegistro egressoRegistro,
			List<Projeto> projetos, Curso curso) {
		super();
		this.anoFormacao = anoFormacao;
		this.foto = foto;
		this.nome = nome;
		this.perfil = perfil;
		this.egressoRegistro = egressoRegistro;
		this.projetos = projetos;
		this.curso = curso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getAnoFormacao() {
		return anoFormacao;
	}

	public void setAnoFormacao(Date anoFormacao) {
		this.anoFormacao = anoFormacao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public EgressoRegistro getCadastro() {
		return egressoRegistro;
	}

	public void setCadastro(EgressoRegistro egressoRegistro) {
		this.egressoRegistro = egressoRegistro;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
