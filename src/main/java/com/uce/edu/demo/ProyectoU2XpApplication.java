package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// Actualizar con JPQL
		int resultado = this.iPersonaJpaService.actualizarPorApellido("Femenino", "Perez");
		LOG.info("Cantidad de registros actualizados: "+ resultado);
		//Eliminar con JPQL
		int resultado2= this.iPersonaJpaService.eliminarPorGenero("Masculino");
		LOG.info("Cantidad de eliminados: "+ resultado2);
		
	}

}
