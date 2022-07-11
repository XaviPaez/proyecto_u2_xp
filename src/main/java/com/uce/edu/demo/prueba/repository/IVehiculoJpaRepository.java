package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;
public interface IVehiculoJpaRepository {

	public void insertar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo);
	public int eliminar(String placa);
	public Vehiculo buscar(String placa);
	
}
