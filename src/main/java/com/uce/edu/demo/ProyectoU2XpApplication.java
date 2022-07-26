package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2;
import com.uce.edu.demo.repository.modelo.manytomany.LibroAutor;
import com.uce.edu.demo.service.IAutor2Service;
import com.uce.edu.demo.service.ILibro2Service;
import com.uce.edu.demo.service.ILibroAutorService;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2XpApplication.class);

	@Autowired
	private ILibro2Service iLibro2Service;
	@Autowired
	private IAutor2Service autor2Service;
	@Autowired
	private ILibroAutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		//1 libro que tiene dos autores
		
		LOG.info("1. libro que tiene dos autores");
		Libro2 libro2=new Libro2();
		libro2.setTitulo("Soccer");
		libro2.setCantidadPaginas(100);
		
		Autor2 autor2=new Autor2();
		autor2.setNombre("David Beckam");
		
		Autor2 autor3=new Autor2();
		autor3.setNombre("Claudio bieler");
		
		List<LibroAutor> lista= new ArrayList<>();
		LibroAutor libroAutor=new LibroAutor();
		libroAutor.setAutor2(autor2);
		libroAutor.setLibro2(libro2);
		lista.add(libroAutor);
		
		LibroAutor libroAutor2=new LibroAutor();
		libroAutor2.setAutor2(autor3);
		libroAutor2.setLibro2(libro2);
		lista.add(libroAutor2);
		
		libro2.setLibroAutor(lista);
		
		this.iLibro2Service.insertar(libro2);
		
		//1 autor que escribió dos libros
		LOG.info("1 autor que escribió dos libros");
		Autor2 autor=new Autor2();
		autor.setNombre("Bryan Adamms");
		
		Libro2 libro=new Libro2();
		libro.setTitulo("Musica");
		libro.setCantidadPaginas(150);
		
		Libro2 libro1=new Libro2();
		libro1.setTitulo("Rock");
		libro1.setCantidadPaginas(250);
		
		List<LibroAutor> lista1 = new ArrayList<>();
		LibroAutor libroAutor1=new LibroAutor();
		libroAutor1.setAutor2(autor);
		libroAutor1.setLibro2(libro);
		lista1.add(libroAutor1);
		
		LibroAutor libroAutor4=new LibroAutor();
		libroAutor4.setAutor2(autor);
		libroAutor4.setLibro2(libro1);
		lista1.add(libroAutor4);
		
		autor.setLibroAutor(lista1);
		
		this.autor2Service.insertar(autor);
		
		
	}
}
