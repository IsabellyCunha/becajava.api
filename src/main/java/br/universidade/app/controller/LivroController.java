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

import br.universidade.app.model.*;
import br.universidade.app.service.*;

@RestController
@RequestMapping("/livros")
public class LivroController {
	private final LivroService _service;

	@Autowired
	public LivroController(LivroService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Livro livro) {
		try {
			_service.inserir(livro);
			return ResponseEntity.status(HttpStatus.CREATED).body("Livro inserido com sucesso!");

		} catch (Error e) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível o cadastro do Livro!");
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Livro> livros = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(livros);
		} catch (Error e) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Não existe nenhum Livro!");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listarUm(@PathVariable Long id) {
		try {
			Optional<Livro> livro = _service.listarUm(id);
			return ResponseEntity.status(HttpStatus.OK).body(livro);
		} catch (Error e) {
			return ResponseEntity.status(HttpStatus.CREATED).body("livro não existe!");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Livro livro) {
		try {
			_service.atualizar(id, livro);
			return ResponseEntity.status(HttpStatus.OK).body("Livro atualizado com sucesso!!!");
		} catch (Error e) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível a atualização!");
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		try {
			_service.excluir(id);
			return ResponseEntity.status(HttpStatus.OK).body("Livro excluídada com sucesso!!!");
		} catch (Error e) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Não é possível excluir!");
		}
	}
}
