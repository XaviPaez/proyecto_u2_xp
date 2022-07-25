package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Actor;
import com.uce.edu.demo.repository.modelo.onetomany.Pelicula;
import com.uce.edu.demo.service.IActorService;
import com.uce.edu.demo.service.ICiudadanoPJpaService;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;
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

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		

		LOG.info("\n");
		LOG.info("Insertar");
		Pelicula pelicula1=new Pelicula();
		pelicula1.setNombre("Spiderman 2");
		pelicula1.setFechaEstreno(LocalDateTime.now());
		this.iPeliculaService.insertar(pelicula1);
		
		
		LOG.info("\n");
		LOG.info("Actualizar");
		pelicula1.setNombre("Spiderman 4");
		this.iPeliculaService.actualizar(pelicula1);
		
		LOG.info("\n");
		LOG.info("Buscar");
		LOG.info("Pelicula encontrada: "+this.iPeliculaService.buscar(2));
		
		LOG.info("\n");
		LOG.info("Eliminar");
		this.iPeliculaService.eliminar(2);
		
	}
}
