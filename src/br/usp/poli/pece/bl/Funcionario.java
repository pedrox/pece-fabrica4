package br.usp.poli.pece.bl;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Usuario {
	private String carteiraTrabalho;

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}
	
}
