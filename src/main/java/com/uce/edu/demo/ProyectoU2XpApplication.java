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

		
		//1. NativeQuery
		
		LOG.info("\n");
		
		LOG.info("Native");
		LOG.info("*********1**********");
		List<Estudiante> estuNative = this.estudianteJpaService.buscarPorApellidoNative("Cadena");
		for(Estudiante estudiante: estuNative) {
			LOG.info("Estudiante Native: "+ estudiante);
		
	}

		LOG.info("*********2**********");
		List<Estudiante> estuNative1 = this.estudianteJpaService.buscarPorSemestreNative("Sexto");
		for(Estudiante estudiante: estuNative1) {
			LOG.info("Estudiante Native1: "+ estudiante);
		
	}
		LOG.info("\n");
		LOG.info("Named Native");
		LOG.info("*********1**********");
		//2. NamedNativeQuery
		List<Estudiante> estuNamedNative = this.estudianteJpaService.buscarPorNombreGeneroNamedNative("Isabel", "Femenino");
		for(Estudiante estudiante: estuNamedNative) {
			LOG.info("Estudiante namednative: "+ estudiante);
						
		}
		LOG.info("*********2**********");
		List<Estudiante> estuNamedNative1 = this.estudianteJpaService.buscarPorSemestreGeneroNamedNative("Octavo", "Femenina");
		for(Estudiante estudiante: estuNamedNative1) {
			LOG.info("Estudiante namednative1: "+ estudiante);
						
		}
		

}}
