package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Actor;

public interface IActorRepository {

	public void insertar(Actor actor);

	public Actor buscar(Integer id);

	public void actualizar(Actor actor);

	public void  eliminar(Integer id);
}
