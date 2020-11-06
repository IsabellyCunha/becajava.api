package br.universidade.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.universidade.app.model.*;
import br.universidade.app.service.*;

@RestController
@RequestMapping("/autores")
public class AutorController {
	private final AutorService _service;

	@Autowired
	public AutorController(AutorService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Autor autor) {
		try {
			_service.inserir(autor);
			return ResponseEntity.status(HttpStatus.CREATED).body("autor inserido com sucesso!");

		} catch (Error e) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível o cadastro do autor!");
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Autor> autores = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(autores);
		} catch (Error e) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Não existe nenhum autor!");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listarUm(@PathVariable Long id) {
		try {
			Optional<Autor> autor = _service.listarUm(id);
			return ResponseEntity.status(HttpStatus.OK).body(autor);
		} catch (Error e) {
			return ResponseEntity.status(HttpStatus.CREATED).body("autor não existe!");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Autor autor) {
		try {
			_service.atualizar(id, autor);
			return ResponseEntity.status(HttpStatus.OK).body("Autor atualizado com sucesso!!!");
		} catch (Error e) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível a atualização!");
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		try {
			_service.excluir(id);
			return ResponseEntity.status(HttpStatus.OK).body("Autor excluídada com sucesso!!!");
		} catch (Error e) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Não é possível excluir!");
		}
	}
}
