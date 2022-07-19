package com.uce.edu.demo.repository.modelo;

public class PersonaContadorGenero {

	private String genero;
	private Long numero;


	public PersonaContadorGenero() {
		// TODO Auto-generated constructor stub
	}
	

	public PersonaContadorGenero(String genero, Long numero) {
		super();
		this.genero = genero;
		this.numero = numero;
	}
	

	@Override
	public String toString() {
		return "PersonaContadorGenero [genero=" + genero + ", numero=" + numero + "]";
	}

	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}



}