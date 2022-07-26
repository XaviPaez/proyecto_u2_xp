package com.uce.edu.demo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.repository.modelo.onetomany.Actor;
import com.uce.edu.demo.repository.modelo.onetomany.Pelicula;
import com.uce.edu.demo.service.IActorService;
import com.uce.edu.demo.service.ICiudadanoPJpaService;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ILibroService;
import com.uce.edu.demo.service.IPeliculaService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2XpApplication.class);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	@Autowired
	private IEstudianteJpaService estudianteJpaService;

	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private ICiudadanoPJpaService ciudadanoPJpaService;
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private IPeliculaService iPeliculaService;
	@Autowired
	private IActorService actorService;
	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	
		
		Autor autor=new Autor();
		autor.setNombre("Bryan Adams");
		Set<Autor> autors=new HashSet<>();
		autors.add(autor);
	
		
		Libro libro= new Libro();
		libro.setTitulo("Musica");
		libro.setCantidadPaginas(100);
		libro.setAutors(autors);
		
		this.iLibroService.insertar(libro);
		

		

		
	}
}
