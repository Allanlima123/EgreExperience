package main.root.model;

import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Estudante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date anoFormacao;
    
	private String Foto;
	private String email;
	private String nome;
	
	@JoinColumn(name = "perfil_id")
	@ManyToOne
	private Perfil perfil;
	
	@JoinColumn(name = "cadastro_id")
	@ManyToOne
    private Cadastro cadastro;
    
    @JoinColumn(name = "curso_id")
    @ManyToOne
    private Curso curso;
}
