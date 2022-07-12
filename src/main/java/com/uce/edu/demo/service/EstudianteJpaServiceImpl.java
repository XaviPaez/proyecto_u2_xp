package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.repository.modelo.Estudiante;
@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService {

	@Autowired
	private IEstudianteJpaRepository estudianteJpaRepository;
	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(int cedula) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.eliminar(cedula);
	}

	@Override
	public Estudiante buscarPorId(int cedula) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorId(cedula);
	}

	@Override
	public Estudiante buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCedulaTyped(cedula);
	}

	@Override
	public List<Estudiante> buscarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorApellidoTyped(apellido);
	}

	@Override
	public Estudiante buscarPorNombreNamed(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorNombreNamed(nombre);
	}

	@Override
	public List<Estudiante> buscarPorSemestreNamed(String semestre) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorSemestreNamed(semestre);
	}

	@Override
	public List<Estudiante> buscarPorSemestreEdadGeneroTypedNamed(String semestre, String edad, String genero) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorSemestreEdadGeneroTypedNamed(semestre, edad, genero);
	}

	@Override
	public List<Estudiante> buscarPorSemestreGeneroTypednamed(String semestre, String genero) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorSemestreGeneroTypednamed(semestre, genero);
	}

}
