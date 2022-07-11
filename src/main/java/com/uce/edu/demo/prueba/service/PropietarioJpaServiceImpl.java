package com.uce.edu.demo.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.repository.IPropietarioJpaRepository;
import com.uce.edu.demo.prueba.repository.modelo.Propietario;

@Service
public class PropietarioJpaServiceImpl implements IPropiertarioJpaService{

	@Autowired
	private IPropietarioJpaRepository iPropietarioJpaRepository;
	
	@Override
	public void crear(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioJpaRepository.crear(propietario);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.iPropietarioJpaRepository.eliminar(cedula);
	}

	@Override
	public Propietario consultar(String cedula) {
		// TODO Auto-generated method stub
		return this.iPropietarioJpaRepository.consultar(cedula);
	}

}
