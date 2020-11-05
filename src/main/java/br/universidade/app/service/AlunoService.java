package br.universidade.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.universidade.app.model.Aluno;
import br.universidade.app.model.Professor;
import br.universidade.app.repository.AlunoRepository;
import br.universidade.app.repository.ProfessorRepository;

@Service
public class AlunoService {
	
	final AlunoRepository _repository;
	
	@Autowired
	public AlunoService(AlunoRepository repository) {
		_repository = repository;
	}	
	
	public void inserir(Aluno aluno) {
		aluno.setId(new Long(0));
		_repository.save(aluno);		
	}
	
	public List<Aluno> listar(){	
		return _repository.findAll();
	}

}
