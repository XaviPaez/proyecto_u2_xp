package com.uce.edu.demo.prueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.repository.modelo.Propietario;
@Repository
@Transactional
public class PropietarioJpaRepositoryImpl implements IPropietarioJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(Propietario propietario) {
		// TODO Auto-generated method stub
		//System.out.println("Se crea el propietario: "+ propietario);
		this.entityManager.persist(propietario);
	}

	@Override
	public int eliminar(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("DELETE FROM Propietario p WHERE p.cedula = :datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.executeUpdate();
	}

	@Override
	public Propietario consultar(String cedula) {
		// TODO Auto-generated method stub
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Propietario)jpqlQuery.getSingleResult();
		
	}

}
