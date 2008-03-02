package br.usp.poli.pece.bl;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	@Id @GeneratedValue
	protected long id;
	
	@Column(unique=true, nullable=false)
	private String nome;
	
	@Column(unique=true, nullable=false)
	private String codCurso;
	
	private short cargaHoraria;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(nullable=false)
	private Professor coordenador;
	
	@OneToMany(mappedBy="curso")
	private Set<Disciplina> disciplinas;

	@OneToMany(mappedBy="curso")
	private Set<Matricula> matriculas;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	public short getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(short cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Professor getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Professor coordenador) {
		this.coordenador = coordenador;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Set<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	
	
}
