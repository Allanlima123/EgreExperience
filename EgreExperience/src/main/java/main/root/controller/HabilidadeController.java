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

import main.root.model.Habilidade;
import main.root.service.HabilidadeService;

@RestController
@RequestMapping("habilidade")
public class HabilidadeController {
	@Autowired
	HabilidadeService habilidadeService;

	@GetMapping
	public List<Habilidade> listarHabilidades() {
		return habilidadeService.buscarTodosHabilidades();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Habilidade> buscarHabilidadePorId(@PathVariable long id) {
		Habilidade habilidade = habilidadeService.buscarPorId(id);
		if (habilidade != null) {
			return new ResponseEntity<>(habilidade, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public Habilidade criarHabilidade(@RequestBody Habilidade habilidade) {
		return habilidadeService.salvarHabilidade(habilidade);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Habilidade> atualizarHabilidade(@PathVariable long id,
			@RequestBody Habilidade habilidadeAtualizado) {
		try {
			Habilidade habilidade = habilidadeService.atualizarHabilidade(id, habilidadeAtualizado);
			return ResponseEntity.ok(habilidade);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarHabilidade(@PathVariable long id) {
		habilidadeService.deleteHabilidade(id);
		return ResponseEntity.noContent().build();
	}
}
