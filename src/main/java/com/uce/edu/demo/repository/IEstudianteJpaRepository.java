package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.EstudianteContadorSemestre;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;

public interface IEstudianteJpaRepository {

	public Estudiante buscarPorId(int cedula);

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(int cedula);

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
