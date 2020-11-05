package br.universidade.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.universidade.app.model.Disciplina;
import br.universidade.app.service.DisciplinaService;


@RestController

@RequestMapping("/disciplinas")
public class DisciplinaController {
	
private final DisciplinaService _service;
	
	@Autowired
	public DisciplinaController(DisciplinaService service) {
		_service = service;
	}
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody Disciplina disciplina) {
		_service.inserir(disciplina);
		return ResponseEntity.status(HttpStatus.CREATED).body("Disciplina inserido com sucesso!");
    }
	
	@GetMapping
    public ResponseEntity listar() {		
		Iterable<Disciplina> disciplinas = _service.listar();  		
    	return ResponseEntity.status(HttpStatus.OK).body(disciplinas);
    }
}

