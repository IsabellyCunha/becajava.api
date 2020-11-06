package br.universidade.app.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.universidade.app.model.*;
import br.universidade.app.repository.*;

@Service
public class CursoService {
final CursoRepository _repository;
	
	@Autowired
	public CursoService(CursoRepository repository) {
		_repository = repository;
	}	
	
	public void inserir(Curso curso) {
		curso.setId(new Long(0));
		_repository.save(curso);		
	}
	
	public List<Curso> listar(){	
		return _repository.findAll();
	}
	
	public Optional<Curso> listarUm(Long Id) {
		return _repository.findById(Id);
	}

	public void atualizar(Long id, Curso curso) {
		curso.setId(id);
		_repository.save(curso);
	}

	public void excluir(Long id) {
		_repository.deleteById(id);
	}
}
