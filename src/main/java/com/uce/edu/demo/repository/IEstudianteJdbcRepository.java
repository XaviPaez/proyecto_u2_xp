package com.uce.edu.demo.repository;

import com.uce.edu.demo.to.Estudiante;
import com.uce.edu.demo.to.PersonaTo;

public interface IEstudianteJdbcRepository {
	public Estudiante buscarPorId(int cedula);
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void eliminar(int cedula);
}
