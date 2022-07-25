package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Actor;

@Repository
@Transactional
public class ActorRepositoryImpl implements IActorRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Actor actor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(actor);
	}

	@Override
	public Actor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Actor.class, id);
	}

	@Override
	public void actualizar(Actor actor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(actor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Actor actor=this.buscar(id);
		this.entityManager.remove(actor);
		
		
	}

}
