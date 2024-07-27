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

import main.root.model.CursoPos;
import main.root.service.CursoPosService;

@RestController
@RequestMapping("cursoPos")
public class CursoPosController {
	@Autowired
	CursoPosService cursoPosService;
	
	@PostMapping
	public ResponseEntity<CursoPos> addCursoPos(@RequestBody CursoPos cursoPos) {
		try {
			CursoPos savedCursoPos = cursoPosService.salvarCursoPos(cursoPos);
			return new ResponseEntity<>(savedCursoPos, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<CursoPos> atualizarCursoPos(
            @PathVariable int id,
            @RequestBody CursoPos cursoPosAtualizado) {
        try {
            CursoPos cursoPos = cursoPosService.atualizarCursoPos(id, cursoPosAtualizado);
            return ResponseEntity.ok(cursoPos);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCursoPos(@PathVariable int id) {
    	cursoPosService.deletePosCurso(id);
        return ResponseEntity.noContent().build();
    }
}
