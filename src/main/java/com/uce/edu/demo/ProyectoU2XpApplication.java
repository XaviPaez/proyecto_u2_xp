package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2XpApplication.class);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	@Autowired
	private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
	
		LOG.info("\n");
		LOG.info("Estudiante Criteria Api 1");
		List<Estudiante> estuDinamica= this.estudianteJpaService.buscarDinamicamenteSemestreApellidoEdad("Sexto", "Acosta", "22");
		for(Estudiante estudianteDinamica: estuDinamica) {
			LOG.info("Estudiante Dinamico: "+ estudianteDinamica);
		}
		LOG.info("\n");
		LOG.info("Estudiante Criteria Api 2");
		List<Estudiante> estuDinamica1= this.estudianteJpaService.buscarDinamicamentePorLetraSemestreApellido("Acosta", "A", "Primero");
		for(Estudiante estudianteDinamica: estuDinamica1) {
			LOG.info("Estudiante Dinamico: "+ estudianteDinamica);
		}
		
}}
