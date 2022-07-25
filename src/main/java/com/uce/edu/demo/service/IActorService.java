package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetomany.Actor;

public interface IActorService {
	
	public void insertar(Actor actor);

	public Actor buscar(Integer id);

	public void actualizar(Actor actor);

	public void  eliminar(Integer id);
}
