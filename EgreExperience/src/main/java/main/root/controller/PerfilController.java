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

import main.root.dto.PerfilDto;
import main.root.model.Perfil;
import main.root.service.PerfilService;

@RestController
@RequestMapping("perfil")
public class PerfilController {
	@Autowired
	PerfilService perfilService;
	
    @GetMapping
    public List<Perfil> listarPerfils() {
        return perfilService.listarPerfils();
    }
    
    @PostMapping
    public Perfil addPerfil(@RequestBody PerfilDto perfilDto) {
        return perfilService.addPerfil(perfilDto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Perfil> buscarPerfilPorId(@PathVariable int id) {
        Perfil perfil = perfilService.buscarPerfilPorId(id);
        if (perfil != null) {
            return new ResponseEntity<>(perfil, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
    
//    @PutMapping("/{id}")
//    public ResponseEntity<Perfil> atualizarPerfil(
//            @PathVariable int id,
//            @RequestBody Perfil perfilAtualizado) {
//        try {
//            Perfil perfil = perfilService.atualizarPerfil(id, perfilAtualizado);
//            return ResponseEntity.ok(perfil);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPerfil(@PathVariable Long id) {
    	perfilService.deletePerfil(id);
        return ResponseEntity.noContent().build();
    }
}
