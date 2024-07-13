package main.root.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Emprego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String empresa;
	private Boolean remoto;
	private String cargo;
	private String tempo;
	
    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;
    
    @OneToMany(mappedBy = "emprego", cascade = CascadeType.ALL)
    private List<Participacoes> participacoes = new ArrayList<>();
}
