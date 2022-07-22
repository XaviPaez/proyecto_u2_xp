package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadanoPJpaRepository;
import com.uce.edu.demo.repository.modelo.CiudadanoP;

@Service
public class CiudadanoPJpaServiceImpl implements ICiudadanoPJpaService {

	@Autowired
	private ICiudadanoPJpaRepository ciudadanoPJpaRepository;
	
	@Override
	public void insertar(CiudadanoP ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoPJpaRepository.insertar(ciudadano);
	}

	@Override
	public CiudadanoP buscar(Integer id) {
		// TODO Auto-generated method stub
	return this.ciudadanoPJpaRepository.buscar(id);
	}

	@Override
	public void actualizar(CiudadanoP ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoPJpaRepository.actualizar(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.ciudadanoPJpaRepository.eliminar(id);
	}

}
