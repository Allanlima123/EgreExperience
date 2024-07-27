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

import main.root.model.Perfil;
import main.root.service.PerfilService;


@RestController
@RequestMapping("perfil")
public class PerfilController {
	
	@Autowired
	PerfilService perfilService;
	
	@PostMapping
	public ResponseEntity<Perfil> addPerfil(@RequestBody Perfil perfil) {
		try {
			Perfil salvarPerfil = perfilService.salvarPerfil(perfil);
			return new ResponseEntity<>(salvarPerfil, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Perfil> atualizarPerfil(
            @PathVariable long id,
            @RequestBody Perfil PerfilAtualizado) {
        try {
        	Perfil perfil = perfilService.atualizarPerfil(id, PerfilAtualizado);
            return ResponseEntity.ok(perfil);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPerfil(@PathVariable long id) {
    	perfilService.deletePerfil(id);
        return ResponseEntity.noContent().build();
    }
}
