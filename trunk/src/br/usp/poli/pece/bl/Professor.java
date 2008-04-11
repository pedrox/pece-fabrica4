package br.usp.poli.pece.bl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.usp.poli.pece.db.MatriculaDAO;

@Entity
public class Professor extends Usuario {
	@Column(unique=true)
	private String carteiraTrabalho;

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}
	
	public static List<Matricula> listaMatriculasAvaliacaoInicia(int idCoordenador) {
		return MatriculaDAO.getMatriculaByStatus(Matricula.Status.PAGO, idCoordenador);
	}
	
	public static List<Matricula> listaMatriculasAvaliacaoEntrevista(int idCoordenador) {
		return MatriculaDAO.getMatriculaByStatus(Matricula.Status.AGENDAR_ENTREVISTA, idCoordenador);
	}
	
}
