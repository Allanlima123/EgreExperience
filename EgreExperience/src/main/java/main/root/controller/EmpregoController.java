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

import main.root.dto.EmpregoDto;
import main.root.model.Emprego;
import main.root.service.EmpregoService;

@RestController
@RequestMapping("emprego")
public class EmpregoController {
	@Autowired
	EmpregoService empregoService;

	@GetMapping
	public List<Emprego> listarEmpregos() {
		return empregoService.listarEmpregos();
	}

	@PostMapping
	public Emprego addEmprego(@RequestBody EmpregoDto empregoDto) {
		return empregoService.addEmprego(empregoDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Emprego> buscarEmpregoPorId(@PathVariable int id) {
		Emprego emprego = empregoService.buscarEmpregoPorId(id);
		if (emprego != null) {
			return new ResponseEntity<>(emprego, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/estudante/{id}")
	public List<Emprego> getEmpregosPorEstudante(@PathVariable("id") Long estudanteId) {
		return empregoService.buscarEmpregosPorEstudante(estudanteId);
	}
	

    @PutMapping("/{id}")
    public ResponseEntity<Emprego> atualizarEmprego(
            @PathVariable int id,
            @RequestBody EmpregoDto empregoDto) {
        try {
            Emprego emprego = empregoService.atualizarEmprego(id, empregoDto);
            return ResponseEntity.ok(emprego);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    

 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmprego(@PathVariable Long id) {
    	empregoService.deleteEmprego(id);
        return ResponseEntity.noContent().build();
    }
}
