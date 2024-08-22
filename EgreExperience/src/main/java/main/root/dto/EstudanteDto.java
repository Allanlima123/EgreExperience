package main.root.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import main.root.model.Idioma;

@Data
public class EstudanteDto {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date anoFormacao;

	private String foto;
	private String nome;
	private String descricaoTecnica;
	private String cargoAtual;
	private List<Idioma> idiomas;
	private Long perfilId;
}
