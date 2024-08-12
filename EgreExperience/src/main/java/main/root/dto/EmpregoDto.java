package main.root.dto;

import lombok.Data;

@Data
public class EmpregoDto {
	private String empresa;
	private Boolean remoto;
	private String cargo;
	private String tempo;
	private String descricaoProficional;
	private Long estudanteId;
}
