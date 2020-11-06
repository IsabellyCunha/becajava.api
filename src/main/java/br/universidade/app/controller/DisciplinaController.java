package br.universidade.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	
	@GetMapping(path = "/{id}")
    public ResponseEntity listarUm(@PathVariable Long id) {    	  	    	
		Optional<Disciplina> disciplina = _service.listarUm(id);   	
        return ResponseEntity.status(HttpStatus.OK).body(disciplina);
    }
	
	@PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina) {    	  	    	
		_service.atualizar(id, disciplina);   	
        return ResponseEntity.status(HttpStatus.OK).body("disciplina atualizado com sucesso!!!");
    }
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		_service.excluir(id);
		return ResponseEntity.status(HttpStatus.OK).body("disciplina excluídada com sucesso!!!");
	}
}

