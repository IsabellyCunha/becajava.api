package br.universidade.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
