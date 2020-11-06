package br.universidade.app.model;

import javax.persistence.*;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Titulo;
	private String DataPublicacao;
	private String Editora;
	private int AnoPublicacao;
	
	@ManyToOne
	@JoinColumn(name = "DisciplinaId")
	private Disciplina Disciplina;
	
	public Disciplina getDisciplina() {
		return Disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		Disciplina = disciplina;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getDataPublicacao() {
		return DataPublicacao;
	}
	public void setDataPublicacao(String dataPublicacao) {
		DataPublicacao = dataPublicacao;
	}
	public String getEditora() {
		return Editora;
	}
	public void setEditora(String editora) {
		Editora = editora;
	}
	public int getAnoPublicacao() {
		return AnoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		AnoPublicacao = anoPublicacao;
	}
	
	
}
