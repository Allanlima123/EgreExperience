package main.root.controller;

import java.util.List;
import java.util.Optional;

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

import main.root.model.Estudante;
import main.root.service.EstudanteService;

@RestController
@RequestMapping("estudante")
public class EstudanteController {
    @Autowired
    EstudanteService estudanteService;

    @PostMapping
    public ResponseEntity<Estudante> addEstudante(@RequestBody Estudante estudante) {
        try {
            Estudante savedEstudante = estudanteService.salvarEstudante(estudante);
            return new ResponseEntity<>(savedEstudante, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
	@GetMapping
	public List<Estudante> listarEstudantes() {
		return estudanteService.obterTodosEstudantes();
	}

//    @GetMapping
//    public ResponseEntity<List<Estudante>> getAllEstudantes() {
//        try {
//            List<Estudante> estudantes = estudanteService.obterTodosEstudantes();
//            return new ResponseEntity<>(estudantes, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> getEstudanteById(@PathVariable Long id) {
        Optional<Estudante> estudante = estudanteService.obterEstudantePorId(id);
        if (estudante.isPresent()) {
            return new ResponseEntity<>(estudante.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Estudante> updateEstudante(@PathVariable Long id, @RequestBody Estudante estudante) {
//        try {
//            Estudante updatedEstudante = estudanteService.atualizarEstudante(id, estudante);
//            return new ResponseEntity<>(updatedEstudante, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEstudante(@PathVariable Long id) {
        try {
            estudanteService.deletarEstudante(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
