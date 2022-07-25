package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Pelicula;

public interface IPeliculaRepository {

	public void insertar(Pelicula pelicula);

	public Pelicula buscar(Integer id);

	public void actualizar(Pelicula pelicula);

	public void  eliminar(Integer id);
}
