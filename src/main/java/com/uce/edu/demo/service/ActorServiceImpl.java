package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IActorRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Actor;

@Service
public class ActorServiceImpl implements IActorService{

	@Autowired
	private IActorRepository actorRepository;
	
	@Override
	public void insertar(Actor actor) {
		// TODO Auto-generated method stub
		this.actorRepository.insertar(actor);
	}

	@Override
	public Actor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.actorRepository.buscar(id);
	}

	@Override
	public void actualizar(Actor actor) {
		// TODO Auto-generated method stub
		this.actorRepository.actualizar(actor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.actorRepository.eliminar(id);
	}

}
