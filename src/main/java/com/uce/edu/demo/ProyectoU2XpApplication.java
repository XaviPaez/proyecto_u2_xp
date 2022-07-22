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

import com.uce.edu.demo.repository.modelo.CiudadanoP;
import com.uce.edu.demo.repository.modelo.Pasaporte;
import com.uce.edu.demo.service.ICiudadanoPJpaService;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IEstudianteJpaService;
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

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		LOG.info("\n");
		
		CiudadanoP ciudadanoP = new CiudadanoP();
		ciudadanoP.setNombre("Claudio");
		ciudadanoP.setApellido("Bieler");
		ciudadanoP.setCedula("171312");
		ciudadanoP.setfechaNacimiento(LocalDateTime.now());

		Pasaporte pasaporte = new Pasaporte();
		pasaporte.setNumero("12455");
		pasaporte.setFechaCaducidad(LocalDateTime.now());
		pasaporte.setFechaEmision(LocalDateTime.now());
		pasaporte.setCiudadanop(ciudadanoP);

		LOG.info("Insertar ciudadano");
		ciudadanoP.setPasaporte(pasaporte);
		LOG.info("Insertar ciudadano: ");
		this.ciudadanoPJpaService.insertar(ciudadanoP);
		LOG.info("\n");
		LOG.info("Actualizar ciudadano");
		ciudadanoP.setNombre("Sebastian");
		
		this.ciudadanoPJpaService.actualizar(ciudadanoP);
		LOG.info("\n");
		LOG.info("Buscar ciudadano"+ this.ciudadanoPJpaService.buscar(2));
		
		LOG.info("\n");
		LOG.info("Eliminar ciudadano");
		this.ciudadanoPJpaService.eliminar(4);
		LOG.info("\n");

	}
}
