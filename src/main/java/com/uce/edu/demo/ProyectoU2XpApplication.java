package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IEstudianteJdbcService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {

		
		private static final Logger LOG= LoggerFactory.getLogger(ProyectoU2XpApplication.class);
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
			
			//BUSCAR
			//LOG.info("Dato con JPA: " + this.iPersonaJpaService.buscarPorId(1));
			
			Persona per = new Persona();
			//per.setId(8);
			per.setNombre("Pepito12");
			per.setApellido("Perez");

			// GUARDAR
			this.iPersonaJpaService.guardar(per);

			Persona per1 = new Persona();
			per1.setId(3);
			per1.setNombre("Emma");
			per1.setApellido("Ruiz");

			// ACTUALIZACION
			//this.iPersonaJpaService.actualizar(per1);

			// ELIMINAR
			//this.iPersonaJpaService.eliminar(2);

	}

}
