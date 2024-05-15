package main.root.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Estudante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date anoFormacao;
    
	private String Foto;
	private String email;
	
	@OneToOne(mappedBy = "estudante")
	private Perfil perfil;
	
    @OneToOne(mappedBy = "estudante")
    private Cadastro cadastro;
    
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL)
    private List<Projeto> projetos = new ArrayList<>();
    
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL)
    private List<Emprego> empregos = new ArrayList<>();
    
    @OneToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
	
	public Estudante() {
	}

	
	public Estudante(Date anoFormacao, String foto, String email, Perfil perfil, Cadastro cadastro,
			List<Projeto> projetos, List<Emprego> empregos, Curso curso) {
		this.anoFormacao = anoFormacao;
		Foto = foto;
		this.email = email;
		this.perfil = perfil;
		this.cadastro = cadastro;
		this.projetos = projetos;
		this.empregos = empregos;
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
		return Foto;
	}


	public void setFoto(String foto) {
		Foto = foto;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public Cadastro getCadastro() {
		return cadastro;
	}


	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}


	public List<Projeto> getProjetos() {
		return projetos;
	}


	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}


	public List<Emprego> getEmpregos() {
		return empregos;
	}


	public void setEmpregos(List<Emprego> empregos) {
		this.empregos = empregos;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
	
	
}
