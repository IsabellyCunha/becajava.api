package br.universidade.app.controller;

import java.util.Optional;

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

import br.universidade.app.model.Aluno;
import br.universidade.app.model.Professor;
import br.universidade.app.service.AlunoService;
import br.universidade.app.service.ProfessorService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
private final AlunoService _service;
	
	@Autowired
	public AlunoController(AlunoService service) {
		_service = service;
	}
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody Aluno aluno) {
		_service.inserir(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body("professor inserido com sucesso!");
    }
	
	@GetMapping
    public ResponseEntity listar() {		
		Iterable<Aluno> alunos = _service.listar();  		
    	return ResponseEntity.status(HttpStatus.OK).body(alunos);
    }
	
	@GetMapping(path = "/{id}")
    public ResponseEntity listarUm(@PathVariable Long id) {    	  	    	
		Optional<Aluno> aluno = _service.listarUm(id);   	
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }
	
	@PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {    	  	    	
		_service.atualizar(id, aluno);   	
        return ResponseEntity.status(HttpStatus.OK).body("aluno atualizado com sucesso!!!");
    }
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		_service.excluir(id);
		return ResponseEntity.status(HttpStatus.OK).body("aluno excluídada com sucesso!!!");
	}
}
