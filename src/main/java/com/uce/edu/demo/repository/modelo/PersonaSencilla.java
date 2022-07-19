package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

//No es necesario @table ni @Entity, no es una entidad
public class PersonaSencilla implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;

	@Override
	public String toString() {
		return "PersonaSencilla [nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public PersonaSencilla() {
		// TODO Auto-generated constructor stub

	}

	public PersonaSencilla(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	// todo objeto clase que yo cree siempre tiene un constructor por defecto
	// SET Y GET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
