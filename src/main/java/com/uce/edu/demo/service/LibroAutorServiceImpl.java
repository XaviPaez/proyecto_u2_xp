package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibroAutorRepository;
import com.uce.edu.demo.repository.modelo.manytomany.LibroAutor;

@Service
public class LibroAutorServiceImpl implements ILibroAutorService{

	@Autowired
	private ILibroAutorRepository libroAutorRepository;
	
	@Override
	public void insertar(LibroAutor libroAutor) {
		// TODO Auto-generated method stub
		this.libroAutorRepository.insertar(libroAutor);
	}

}
