package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	
	public void guardar(Estudiante persona);

	public void actualizar(Estudiante persona);

	public void eliminar(int id);

	public Estudiante buscarPorId(int id);
}
