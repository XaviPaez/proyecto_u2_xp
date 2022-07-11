package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.repository.modelo.Propietario;

public interface IPropiertarioJpaService {

	public Propietario consultar(String cedula);
	public void crear(Propietario propietario);
	public void eliminar(String cedula);
}
