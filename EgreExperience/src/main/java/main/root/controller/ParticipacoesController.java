package main.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.dto.ParticipacoesDto;
import main.root.model.Participacoes;
import main.root.service.ParticipacoesService;

@RestController
@RequestMapping("participacoes")
public class ParticipacoesController {
	@Autowired
	ParticipacoesService participacoesService;
	
    @GetMapping
    public List<Participacoes> listarParticipacoess() {
        return participacoesService.listarParticipacoess();
    }
    
    @PostMapping
    public Participacoes addParticipacoes(@RequestBody ParticipacoesDto participacoesDto) {
        return participacoesService.addParticipacoes(participacoesDto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Participacoes> buscarParticipacoesPorId(@PathVariable int id) {
        Participacoes participacoes = participacoesService.buscarParticipacoesPorId(id);
        if (participacoes != null) {
            return new ResponseEntity<>(participacoes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/projeto/{id}")
    public List<Participacoes> getProjetosPorProjetoId(@PathVariable("id") Long projetoId) {
        return participacoesService.buscarParticipacoesPorProjetoId(projetoId);
    }

	
    
//    @PutMapping("/{id}")
//    public ResponseEntity<Participacoes> atualizarParticipacoes(
//            @PathVariable int id,
//            @RequestBody Participacoes participacoesAtualizado) {
//        try {
//            Participacoes participacoes = participacoesService.atualizarParticipacoes(id, participacoesAtualizado);
//            return ResponseEntity.ok(participacoes);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletarParticipacoes(@PathVariable int id) {
//    	participacoesService.deleteParticipacoes(id);
//        return ResponseEntity.noContent().build();
//    }
}
