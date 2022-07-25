package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPeliculaRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	@Autowired
	private IPeliculaRepository iPeliculaRepository;
	
	@Override
	public void insertar(Pelicula pelicula) {
		// TODO Auto-generated method stub
		this.iPeliculaRepository.insertar(pelicula);
	}

	@Override
	public Pelicula buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iPeliculaRepository.buscar(id);
	}

	@Override
	public void actualizar(Pelicula pelicula) {
		// TODO Auto-generated method stub
		this.iPeliculaRepository.actualizar(pelicula);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iPeliculaRepository.eliminar(id);
	}

}
