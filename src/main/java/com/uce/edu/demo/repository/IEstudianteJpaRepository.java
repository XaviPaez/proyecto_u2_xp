package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;

public interface IEstudianteJpaRepository {

	public Estudiante buscarPorId(int cedula);

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(int cedula);

	public Estudiante buscarPorCedulaTyped(String cedula);
	
	public List<Estudiante>  buscarPorApellidoTyped(String apellido);

	public Estudiante buscarPorNombreNamed(String nombre);
	
	public List<Estudiante> buscarPorSemestreNamed(String semestre);
	
	public List<Estudiante> buscarPorSemestreEdadGeneroTypedNamed(String semestre, String edad, String genero);
	
	public List<Estudiante> buscarPorSemestreGeneroTypednamed(String semestre, String genero);


}
