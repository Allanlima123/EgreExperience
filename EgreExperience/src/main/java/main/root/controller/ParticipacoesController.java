package main.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.model.Participacoes;
import main.root.service.ParticipacoesService;

@RestController
@RequestMapping("/participacoes")
public class ParticipacoesController {
	@Autowired
	ParticipacoesService participacoesService;
	
	@PostMapping
	public ResponseEntity<Participacoes> addParticipacoes(@RequestBody Participacoes participacoes) {
		try {
			Participacoes salvarParticipacoes = participacoesService.salvarParticipacoes(participacoes);
			return new ResponseEntity<>(salvarParticipacoes, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
    @PutMapping("/{id}")
    public ResponseEntity<Participacoes> atualizarParticipacoes(
            @PathVariable long id,
            @RequestBody Participacoes participacoesAtualizado) {
        try {
            Participacoes participacoes = participacoesService.atualizarParticipacoes(id, participacoesAtualizado);
            return ResponseEntity.ok(participacoes);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarParticipacoes(@PathVariable long id) {
    	participacoesService.deleteParticipacoes(id);
        return ResponseEntity.noContent().build();
    }
}
