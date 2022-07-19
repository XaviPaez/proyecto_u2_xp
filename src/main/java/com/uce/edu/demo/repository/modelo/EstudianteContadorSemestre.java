package com.uce.edu.demo.repository.modelo;

public class EstudianteContadorSemestre {
	private String semestre;
	private Long numero;

	@Override
	public String toString() {
		return "EstudianteContadorSemestre [semestre=" + semestre + ", numero=" + numero + "]";
	}

	public EstudianteContadorSemestre() {
		// TODO Auto-generated constructor stub
	}

	public EstudianteContadorSemestre(String semestre, Long numero) {
		super();
		this.semestre = semestre;
		this.numero = numero;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

}