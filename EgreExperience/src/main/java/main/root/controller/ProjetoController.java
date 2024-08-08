package main.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.model.Projeto;
import main.root.service.ProjetoService;

@RestController
@RequestMapping("projeto")
public class ProjetoController {
	@Autowired
	ProjetoService projetoService;
	
    @GetMapping
    public List<Projeto> listarProjetos() {
        return projetoService.buscarTodosProjetos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscarProjetoPorId(@PathVariable int id) {
    	Projeto projeto = projetoService.buscarPorId(id);
        if (projeto != null) {
            return new ResponseEntity<>(projeto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PostMapping
	public ResponseEntity<Projeto> addProjeto(@RequestBody Projeto projeto) {
		try {
			Projeto salvarProjeto = projetoService.salvarProjeto(projeto);
			return new ResponseEntity<>(salvarProjeto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualizarProjeto(
            @PathVariable long id,
            @RequestBody Projeto projetoAtualizado) {
        try {
            Projeto projeto = projetoService.atualizarProjeto(id, projetoAtualizado);
            return ResponseEntity.ok(projeto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable long id) {
    	projetoService.deleteProjeto(id);
        return ResponseEntity.noContent().build();
    }
    
}
