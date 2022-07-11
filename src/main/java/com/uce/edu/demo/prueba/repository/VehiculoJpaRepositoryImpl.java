package com.uce.edu.demo.prueba.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;



@Repository
@Transactional
public class VehiculoJpaRepositoryImpl implements IVehiculoJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vehiculo);
	}

	@Override
	public int eliminar(String placa) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("DELETE FROM Vehiculo v WHERE v.placa = :datoPlaca");
		myQuery.setParameter("datoPlaca", placa);
		return myQuery.executeUpdate();
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		Query jpqlQuery=this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa=: datoPlaca");
		jpqlQuery.setParameter("datoPlaca", placa);
		return (Vehiculo)jpqlQuery.getSingleResult();
	}

}
