package main.root.dto;

import java.util.List;

import lombok.Data;
import main.root.model.Nivel;

@Data
public class ParticipacoesDto {
	private String nome;
	private String papel;
	private List<Nivel> nivel;
	private Long projetoId;
}
