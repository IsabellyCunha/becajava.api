package br.universidade.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.universidade.app.model.*;
import br.universidade.app.repository.*;

@Service
public class AutorService {
final AutorRepository _repository;
	
	@Autowired
	public AutorService(AutorRepository repository) {
		_repository = repository;
	}	
	
	public void inserir(Autor autor) {
		autor.setId(new Long(0));
		_repository.save(autor);		
	}
	
	public List<Autor> listar(){	
		return _repository.findAll();
	}
	
	public Optional<Autor> listarUm(Long Id){
		return _repository.findById(Id);
	}
	
	public void atualizar(Long id, Autor autor) {
		autor.setId(id);
		_repository.save(autor);
	}
	
	public void excluir(Long id) {
		_repository.deleteById(id);
	}

}
