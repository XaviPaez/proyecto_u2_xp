package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;

public interface IVehiculoJpaService {

	public void insertar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo);
	public void eliminar(String placa);
	public Vehiculo buscar(String placa);
	
}
