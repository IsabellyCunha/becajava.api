package br.universidade.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.universidade.app.model.*;
import br.universidade.app.service.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	private final CursoService _service;

	@Autowired
	public CursoController(CursoService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Curso curso) {
		_service.inserir(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body("Curso inserido com sucesso!");
	}

	@GetMapping
	public ResponseEntity listar() {
		Iterable<Curso> cursos = _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(cursos);
	}
	
	@GetMapping(path = "/{id}")
    public ResponseEntity listarUm(@PathVariable Long id) {    	  	    	
		Optional<Curso> curso = _service.listarUm(id);   	
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }
	
	@PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Curso curso) {    	  	    	
		_service.atualizar(id, curso);   	
        return ResponseEntity.status(HttpStatus.OK).body("curso atualizado com sucesso!!!");
    }
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		_service.excluir(id);
		return ResponseEntity.status(HttpStatus.OK).body("curso excluídada com sucesso!!!");
	}
}
