package br.universidade.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
