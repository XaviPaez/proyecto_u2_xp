package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.CiudadanoP;

public interface ICiudadanoPJpaService {

	public void insertar(CiudadanoP ciudadano);

	public CiudadanoP buscar(Integer id);

	public void actualizar(CiudadanoP ciudadano);

	public void eliminar(Integer id);
}
