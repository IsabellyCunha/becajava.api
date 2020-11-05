package br.universidade.app.service;

import java.util.List;

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
}
