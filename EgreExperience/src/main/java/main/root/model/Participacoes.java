package main.root.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Participacoes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String tipo;
	private String papel;
	
    @ManyToOne
    @JoinColumn(name = "emprego_id")
    private Emprego emprego;
    
    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
}
