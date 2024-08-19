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

import main.root.dto.CursoDto;
import main.root.model.Curso;
import main.root.service.CursoService;

@RestController
@RequestMapping("curso")
public class CursoController {

	@Autowired
	CursoService cursoService;
	
	
    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }
    
    @PostMapping
    public Curso addCurso(@RequestBody CursoDto cursoDto) {
        return cursoService.addCurso(cursoDto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarCursoPorId(@PathVariable int id) {
        Curso curso = cursoService.buscarCursoPorId(id);
        if (curso != null) {
            return new ResponseEntity<>(curso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/estudante/{id}")
    public List<Curso> getProjetosPorEstudante(@PathVariable("id") Long estudanteId) {
        return cursoService.buscarCursosPorEstudante(estudanteId);
    }
	
    
//    @PutMapping("/{id}")
//    public ResponseEntity<Curso> atualizarCurso(
//            @PathVariable int id,
//            @RequestBody Curso cursoAtualizado) {
//        try {
//            Curso curso = cursoService.atualizarCurso(id, cursoAtualizado);
//            return ResponseEntity.ok(curso);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
    	cursoService.deleteCurso(id);
        return ResponseEntity.noContent().build();
    }
}
