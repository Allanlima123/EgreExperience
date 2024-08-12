package main.root.dto;

import java.util.List;

import lombok.Data;
import main.root.model.Nivel;

@Data
public class HabilidadeDto {
	private String nome;
	private String descricaoTecnica;
	private List<Nivel> nivel;
	private Long estudanteId;
}
