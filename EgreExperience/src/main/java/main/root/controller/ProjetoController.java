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

import main.root.dto.ProjetoDto;
import main.root.model.Projeto;
import main.root.service.ProjetoService;

@RestController
@RequestMapping("projeto")
public class ProjetoController {
	@Autowired
	ProjetoService projetoService;
	
    @GetMapping
    public List<Projeto> listarProjetos() {
        return projetoService.listarProjetos();
    }
    
    @PostMapping
    public Projeto addProjeto(@RequestBody ProjetoDto projetoDto) {
        return projetoService.addProjeto(projetoDto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscarProjetoPorId(@PathVariable int id) {
        Projeto projeto = projetoService.buscarProjetoPorId(id);
        if (projeto != null) {
            return new ResponseEntity<>(projeto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/estudante/{id}")
    public List<Projeto> getProjetosPorEstudante(@PathVariable("id") Long estudanteId) {
        return projetoService.buscarProjetosPorEstudante(estudanteId);
    }
	
    
//    @PutMapping("/{id}")
//    public ResponseEntity<Projeto> atualizarProjeto(
//            @PathVariable int id,
//            @RequestBody Projeto projetoAtualizado) {
//        try {
//            Projeto projeto = projetoService.atualizarProjeto(id, projetoAtualizado);
//            return ResponseEntity.ok(projeto);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable int id) {
    	projetoService.deleteProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
