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
import com.uce.edu.demo.repository.modelo.EstudianteContadorSemestre;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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
		LOG.info("Estudiante sencillo");

		List<EstudianteSencillo> listaEstudianteSencillos = this.estudianteJpaService
				.buscarPorSemestreSencillo("Octavo");
		for (EstudianteSencillo estuItem : listaEstudianteSencillos) {
			LOG.info("Estudiante Sencillo: " + estuItem);
		}
		LOG.info("\n");

		LOG.info("Estudiante sencillo con agrupamiento");
		List<EstudianteContadorSemestre> miListaContadorSemestres = this.estudianteJpaService
				.consultarCantidadPorSemestre();
		for (EstudianteContadorSemestre item : miListaContadorSemestres) {
			LOG.info("Estudiante: " + item);
		}

	}
}
