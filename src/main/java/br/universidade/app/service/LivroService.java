package br.universidade.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.universidade.app.model.*;
import br.universidade.app.repository.*;

@Service
public class LivroService {
final LivroRepository _repository;
	
	@Autowired
	public LivroService(LivroRepository repository) {
		_repository = repository;
	}	
	
	public void inserir(Livro livro) {
		livro.setId(new Long(0));
		_repository.save(livro);		
	}
	
	public List<Livro> listar(){	
		return _repository.findAll();
	}
	
	public Optional<Livro> listarUm(Long Id){
		return _repository.findById(Id);
	}
	
	public void atualizar(Long id, Livro Livro) {
		Livro.setId(id);
		_repository.save(Livro);
	}
	
	public void excluir(Long id) {
		_repository.deleteById(id);
	}

}
