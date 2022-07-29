package com.uce.edu.demo.prueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.repository.modelo.Matricula;

@Repository
@Transactional
public class MatriculaJpaRepositoryImpl implements IMatriculaJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(Matricula matricula) {
		// TODO Auto-generated method stub

	this.entityManager.persist(matricula);
		
	}

}
