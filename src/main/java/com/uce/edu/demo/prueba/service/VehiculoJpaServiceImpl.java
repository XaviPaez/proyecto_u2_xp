package com.uce.edu.demo.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.repository.IVehiculoJpaRepository;
import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;
@Service
public class VehiculoJpaServiceImpl implements IVehiculoJpaService {

	@Autowired
	private IVehiculoJpaRepository iVehiculoJpaRepository;
	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoJpaRepository.insertar(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoJpaRepository.actualizar(vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub

		this.iVehiculoJpaRepository.eliminar(placa);
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoJpaRepository.buscar(placa);
	}

}
