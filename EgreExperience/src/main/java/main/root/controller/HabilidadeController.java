package main.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.dto.HabilidadeDto;
import main.root.model.Habilidade;
import main.root.service.HabilidadeService;

@RestController
@RequestMapping("habilidade")
public class HabilidadeController {
	@Autowired
	HabilidadeService habilidadeService;

	@GetMapping
	public List<Habilidade> listarHabilidades() {
		return habilidadeService.listarHabilidades();
	}

	@PostMapping
	public Habilidade addHabilidade(@RequestBody HabilidadeDto habilidadeDto) {
		return habilidadeService.addHabilidade(habilidadeDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Habilidade> buscarHabilidadePorId(@PathVariable int id) {
		Habilidade habilidade = habilidadeService.buscarHabilidadePorId(id);
		if (habilidade != null) {
			return new ResponseEntity<>(habilidade, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	   @GetMapping("/estudante/{id}")
	    public List<Habilidade> getProjetosPorEstudante(@PathVariable("id") Long estudanteId) {
	        return habilidadeService.buscarHabilidadesPorEstudante(estudanteId);
	    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Habilidade> atualizarHabilidade(
//            @PathVariable int id,
//            @RequestBody Habilidade habilidadeAtualizado) {
//        try {
//            Habilidade habilidade = habilidadeService.atualizarHabilidade(id, habilidadeAtualizado);
//            return ResponseEntity.ok(habilidade);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHabilidade(@PathVariable Long id) {
    	habilidadeService.deleteHabilidade(id);
        return ResponseEntity.noContent().build();
    }
}
