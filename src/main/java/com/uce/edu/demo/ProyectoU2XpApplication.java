package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2XpApplication implements CommandLineRunner {
	
	private static final Logger LOG= LoggerFactory.getLogger(ProyectoU2XpApplication.class);
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2XpApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Persona persona= new Persona();
		persona.setId(3);
		persona.setNombre("Xavier");
		persona.setApellido("Paez");
		//Insertar
		//this.iPersonaJdbcService.guardar(persona);
		Persona persona2=new Persona();
		persona2.setId(3);
		persona2.setNombre("Xavier");
		persona2.setApellido("Martinez");
		//Actualizar
		//this.iPersonaJdbcService.actualizar(persona2);
		
		this.iPersonaJdbcService.eliminar(3);*/
		
		
		LOG.info(this.iPersonaJdbcService.buscarPorId(1).toString());
	}

}
