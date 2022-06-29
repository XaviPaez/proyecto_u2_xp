package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.to.PersonaTo;



public interface IPersonaJdbcRepository {

	public PersonaTo buscarPorId(int id);
	public void insertar(PersonaTo persona);
	public void actualizar(PersonaTo persona);
	public void eliminar(int id);
	public List<PersonaTo> buscarTodos();
	
}
