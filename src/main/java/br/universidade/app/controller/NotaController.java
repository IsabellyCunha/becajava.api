package br.universidade.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.universidade.app.model.*;
import br.universidade.app.service.*;


@RestController
@RequestMapping("/notas")
public class NotaController {
private final NotaService _service;
	
	@Autowired
	public NotaController(NotaService service) {
		_service = service;
	}
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody Nota nota) {
		_service.inserir(nota);
		return ResponseEntity.status(HttpStatus.CREATED).body("nota inserido com sucesso!");
    }
	
	@GetMapping
    public ResponseEntity listar() {		
		Iterable<Nota> notas = _service.listar();  		
    	return ResponseEntity.status(HttpStatus.OK).body(notas);
    }
	
}
