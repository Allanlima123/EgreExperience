package main.root.dto;

import lombok.Data;
import main.root.model.Nivel;

@Data
public class HabilidadeDto {
	private String nome;
	private String descricaoTecnica;
	private Nivel nivel;
	private Long estudanteId;
}
