package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CiudadanoP;

@Transactional
@Repository
public class CiudadanoPJpaRepositoryImpl implements ICiudadanoPJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CiudadanoP ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public CiudadanoP buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CiudadanoP.class, id);
	}

	@Override
	public void actualizar(CiudadanoP ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		CiudadanoP ciudadanoP = this.buscar(id);
		this.entityManager.remove(ciudadanoP);

	}

}
