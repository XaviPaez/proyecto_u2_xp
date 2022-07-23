package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IHabitacionRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	private IHabitacionRepository iHabitacionRepository;

	@Override
	public void insertar(Habitacion habitacion) {
		this.iHabitacionRepository.insertar(habitacion);

	}
}
