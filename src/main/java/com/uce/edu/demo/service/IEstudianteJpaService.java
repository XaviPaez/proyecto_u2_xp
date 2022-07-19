package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.EstudianteContadorSemestre;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

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
	
	public List<Estudiante> buscarPorSemestreNative(String semestre);

	public List<Estudiante> buscarPorApellidoNative(String apellido);

	public List<Estudiante> buscarPorSemestreGeneroNamedNative(String semestre, String genero);

	public List<Estudiante> buscarPorNombreGeneroNamedNative(String nombre, String genero);

	public List<Estudiante> buscarDinamicamenteSemestreApellidoEdad(String semestre, String apellido, String edad);

	public List<Estudiante> buscarDinamicamentePorLetraSemestreApellido(String Apellido, String letra, String semestre);
	
	public List<EstudianteSencillo> buscarPorSemestreSencillo(String semestre);

	public List<EstudianteContadorSemestre> consultarCantidadPorSemestre();

}
