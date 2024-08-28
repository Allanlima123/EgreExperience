package main.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.root.dto.EstudanteDto;
import main.root.model.Estudante;
import main.root.service.EstudanteService;

@RestController
@RequestMapping("estudante")
public class EstudanteController {
	@Autowired
	EstudanteService estudanteService;

    @GetMapping
    public List<Estudante> listarEstudantes() {
        return estudanteService.listarEstudantes();
    }
    
    @PostMapping
    public Estudante addEstudante(@RequestBody EstudanteDto estudanteDto) {
        return estudanteService.addEstudante(estudanteDto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable int id) {
        Estudante estudante = estudanteService.buscarEstudantePorId(id);
        if (estudante != null) {
            return new ResponseEntity<>(estudante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizarEstudante(
            @PathVariable int id,
            @RequestBody EstudanteDto estudanteDto) {
        try {
            Estudante estudanteAtualizado = estudanteService.atualizarEstudante(id, estudanteDto);
            return ResponseEntity.ok(estudanteAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
