package br.universidade.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.universidade.app.model.Professor;
import br.universidade.app.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	final ProfessorRepository _repository;
	
	@Autowired
	public ProfessorService(ProfessorRepository repository) {
		_repository = repository;
	}	
	
	public void inserir(Professor professor) {
		professor.setId(new Long(0));
		_repository.save(professor);		
	}
	
	public List<Professor> listar(){	
		return _repository.findAll();
	}

}
