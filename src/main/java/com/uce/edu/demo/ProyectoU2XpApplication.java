package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.repository.modelo.Propietario;
import com.uce.edu.demo.prueba.repository.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IMatriculaGestorService;
import com.uce.edu.demo.prueba.service.IPropiertarioJpaService;
import com.uce.edu.demo.prueba.service.IVehiculoJpaService;
import com.uce.edu.demo.prueba.service.MatriculaGestorServiceImpl;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IEstudianteJdbcService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2XpApplication.class);
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	@Autowired
	private IEstudianteJdbcService estudianteJdbcService;
	@Autowired
	private IPersonaJpaService iPersonaJpaService;
	@Autowired
	private IPropiertarioJpaService iPropiertarioJpaService;
	@Autowired 
	private IVehiculoJpaService iVehiculoJpaService;
	@Autowired 
	private IMatriculaGestorService gestorService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Persona per = new Persona();
		//per.setId(8);
		per.setNombre("Ricardo");
		per.setApellido("Perez");
		per.setGenero("Masculino");
		per.setCedula("171314");

		// GUARDAR
		//this.iPersonaJpaService.guardar(per);	
		//1 TypedQuery
		Persona perTyped= this.iPersonaJpaService.buscarPorCedulaTyped("1713");
		LOG.info("Persona Typed: "+ perTyped);
		//2 NamedQuery
		Persona perNamed=this.iPersonaJpaService.buscarPorCedulaNamed("1713");
		LOG.info("Persona Named: "+ perNamed);
		//3 TypedQuery y NamedQuery
		Persona perTypedNamed=this.iPersonaJpaService.buscarPorCedulaTypedNamed("1713");
		LOG.info("Persona TypedNamed: "+ perTypedNamed);
		//4 Varios NamedQuery
		List<Persona> listaPersonas=this.iPersonaJpaService.buscarPorNombreApellido("Ricardo", "Perez");
		for(Persona item:listaPersonas) {
			LOG.info("Persona:"+ item);
		}
	}

}
