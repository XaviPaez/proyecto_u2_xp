package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Pelicula;

@Repository
@Transactional
public class PeliculaRepositoryImpl implements IPeliculaRepository {

	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public void insertar(Pelicula pelicula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(pelicula);
	}

	@Override
	public Pelicula buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Pelicula.class, id);
	}

	@Override
	public void actualizar(Pelicula pelicula) {
		// TODO Auto-generated method stub
		this.entityManager.merge(pelicula);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Pelicula pelicula= this.buscar(id);
		this.entityManager.remove(pelicula);
	}

}
