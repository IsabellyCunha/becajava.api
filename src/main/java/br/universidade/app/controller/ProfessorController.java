package br.universidade.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
