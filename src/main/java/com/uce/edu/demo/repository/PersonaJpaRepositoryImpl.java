package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona persona=this.buscarPorId(id);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula=: datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Persona)jpqlQuery.getSingleResult();
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido=: datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}



}