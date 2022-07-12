package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	
	public void guardar(Estudiante persona);

	public void actualizar(Estudiante persona);

	public void eliminar(int id);

	public Estudiante buscarPorId(int id);
	
	public Estudiante buscarPorCedulaTyped(String cedula);
	
	public List<Estudiante> buscarPorApellidoTyped(String apellido);

	public Estudiante buscarPorNombreNamed(String nombre);
	
	public List<Estudiante> buscarPorSemestreNamed(String semestre);
	
	public List<Estudiante> buscarPorSemestreEdadGeneroTypedNamed(String semestre, String edad, String genero);
	
	public List<Estudiante> buscarPorSemestreGeneroTypednamed(String semestre, String genero);
}
