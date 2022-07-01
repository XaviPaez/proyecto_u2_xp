package com.uce.edu.demo.repository;

import com.uce.edu.demo.to.EstudianteTo;
import com.uce.edu.demo.to.PersonaTo;

public interface IEstudianteJdbcRepository {
	public EstudianteTo buscarPorId(int cedula);
	public void insertar(EstudianteTo estudiante);
	public void actualizar(EstudianteTo estudiante);
	public void eliminar(int cedula);
}
