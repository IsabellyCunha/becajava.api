package br.universidade.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.universidade.app.model.*;
import br.universidade.app.repository.*;

@Service
public class NotaService {
	
	final NotaRepository _repository;
	
	@Autowired
	public NotaService(NotaRepository repository) {
		_repository = repository;
	}	
	
	public void inserir(Nota nota) {
		nota.setId(new Long(0));
		_repository.save(nota);		
	}
	
	public List<Nota> listar(){	
		return _repository.findAll();
	}

}
