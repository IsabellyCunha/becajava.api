package br.universidade.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.universidade.app.model.Professor;
import br.universidade.app.repository.ProfessorRepository;
import br.universidade.app.service.ProfessorService;

@RestController

@RequestMapping("/professores")
public class ProfessorController {
	
private final ProfessorService _service;
	
	@Autowired
	public ProfessorController(ProfessorService service) {
		_service = service;
	}
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody Professor professor) {
		_service.inserir(professor);
		return ResponseEntity.status(HttpStatus.CREATED).body("professor inserido com sucesso!");
    }
	
	@GetMapping
    public ResponseEntity listar() {		
		Iterable<Professor> professores = _service.listar();  		
    	return ResponseEntity.status(HttpStatus.OK).body(professores);
    }
	
	@GetMapping(path = "/{id}")
    public ResponseEntity listarUm(@PathVariable Long id) {    	  	    	
		Optional<Professor> professor = _service.listarUm(id);   	
        return ResponseEntity.status(HttpStatus.OK).body(professor);
    }
	
	@PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Professor professor) {    	  	    	
		_service.atualizar(id, professor);   	
        return ResponseEntity.status(HttpStatus.OK).body("professor atualizado com sucesso!!!");
    }
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		_service.excluir(id);
		return ResponseEntity.status(HttpStatus.OK).body("professor excluídada com sucesso!!!");
	}
}
