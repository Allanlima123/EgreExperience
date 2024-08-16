package main.root.dto;

import lombok.Data;
import main.root.model.Nivel;

@Data
public class ParticipacoesDto {
	private String nome;
	private String papel;
	private Nivel nivel;
	private Long projetoId;
}
