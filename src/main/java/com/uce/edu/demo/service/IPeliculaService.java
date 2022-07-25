package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetomany.Pelicula;

public interface IPeliculaService {

	public void insertar(Pelicula pelicula);

	public Pelicula buscar(Integer id);

	public void actualizar(Pelicula pelicula);

	public void  eliminar(Integer id);
}
